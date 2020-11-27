package com.dsb.rest.dao;

import com.dsb.rest.model.Equipment;
import com.dsb.rest.model.Statistic;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class EquipementsDAO {
    private static final int pageSize = 50;

    private List<Equipment> equipmentListSort = null;

    private String name = null;

    private List<String> lastFilteredStats = null;

    private List<Equipment> deserialized(String dir) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Equipment[] equipment = objectMapper.readValue(new FileReader(dir), Equipment[].class);
        return Arrays.asList(equipment);
    }

    public List<Equipment> getAllEquipements(String dir, int page) throws IOException {
        List<Equipment> equipmentList = this.deserialized(dir);

        equipmentList = equipmentList.stream().sorted(Comparator.comparingInt((Equipment e) -> Integer.parseInt(e.getLevel()))).collect(toListReversed());
        return equipmentList.stream().skip(pageSize * (page - 1)).limit(pageSize).collect(Collectors.toList());
    }

    public Integer getTotalEquipement(String dir) throws IOException {
        List<Equipment> equipmentList = this.deserialized(dir);
        return equipmentList.size();
    }

    public List<Equipment> filter(String dir, int page, int level, @Nullable String name, @Nullable List<String> stats) throws IOException {
        if (name != null) {
            return this.filterEquipementsByName(dir, page, level, name);
        } else if (stats != null && stats.size() >= 1) {
            return this.filterEquipementsByStat(dir, page, level, stats);
        } else {
            return this.filterEquipementsByLevel(dir, page, level);
        }
    }

    public List<Equipment> filterEquipementsByLevel(String dir, int page, int level) throws IOException {
        List<Equipment> equipmentList;

        if (equipmentListSort != null) {
            equipmentList = equipmentListSort;
        } else {
            equipmentList = this.deserialized(dir);
        }

        equipmentListSort = equipmentList
                .stream()
                .filter(equipments -> Integer.parseInt(equipments.getLevel()) >= level)
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());

        return equipmentListSort;
    }

    public List<Equipment> filterEquipementsByName(String dir, int page, int level, String name) throws IOException {
        List<Equipment> equipmentList = this.deserialized(dir);

        equipmentListSort = equipmentList
                .stream()
                .filter(equipments -> Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(equipments.getName()).find())
                .filter(equipments -> Integer.parseInt(equipments.getLevel()) <= level)
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(toListReversed());

        return equipmentListSort;
    }

    public List<Equipment> filterEquipementsByStat(String dir, int page, int level, List<String> stats) throws IOException {
        List<Equipment> equipmentList;
        if (equipmentListSort != null) {
            if (stats.size() < this.lastFilteredStats.size()) {
                equipmentList = this.deserialized(dir);
            } else {
                equipmentList = equipmentListSort;
            }
        } else {
            equipmentList = this.deserialized(dir);
        }

        this.lastFilteredStats = stats;

        stats.forEach(s -> equipmentListSort = equipmentList
                .stream()
                .filter(equipments -> equipments.getStatistics().stream().anyMatch(Statistic.getPredicateByLabel(s)))
                .filter(equipments -> Integer.parseInt(equipments.getLevel()) <= level)
                .collect(Collectors.toList())
        );

        equipmentListSort = equipmentListSort
                .stream()
                .sorted(Comparator.comparingInt((Equipment e) -> Integer.parseInt(e.getLevel())))
                .collect(toListReversed());

        equipmentListSort = equipmentListSort
                .stream()
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());

        return equipmentListSort;
    }

    private static <T> Collector<T, ?, List<T>> toListReversed() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }
}
