package com.dsb.rest.dao;

import com.dsb.rest.model.Equipments;
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
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class EquipementsDAO {
    private static final int pageSize = 50;

    private List<Equipments> equipmentsListSort = null;

    private List<Equipments> deserialized(String dir) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Equipments[] equipments = objectMapper.readValue(new FileReader(dir), Equipments[].class);
        return Arrays.asList(equipments);
    }

    public List<Equipments> getAllEquipements(String dir, int page) throws IOException {
        List<Equipments> equipmentsList = this.deserialized(dir);

        equipmentsList = equipmentsList.stream().sorted(Comparator.comparingInt((Equipments e) -> Integer.parseInt(e.getLvl()))).collect(toListReversed());
        return equipmentsList.stream().skip(pageSize * (page - 1)).limit(pageSize).collect(Collectors.toList());
    }

    public Integer getTotalEquipement(String dir) throws IOException {
        List<Equipments> equipmentsList = this.deserialized(dir);
        return equipmentsList.size();
    }

    public List<Equipments> filter(String dir, int page, int level, @Nullable String name, @Nullable List<String> stats) throws IOException {
        if(name != null) {
            return this.filterEquipementsByName(dir, page, level, name);
        } else if(stats != null && stats.size() > 1) {
            stats.forEach(s -> {
                try {
                    this.filterEquipementsByStat(dir, page, level, Statistic.getPredicateByLabel(s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return equipmentsListSort;
        } else {
            return this.filterEquipementsByLevel(dir, page, level);
        }
    }

    public List<Equipments> filterEquipementsByLevel(String dir, int page, int level) throws IOException {
        List<Equipments> equipmentsList = this.deserialized(dir);

        equipmentsListSort = equipmentsList
                .stream()
                .filter(equipments -> Integer.parseInt(equipments.getLvl()) <= level)
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());

        return equipmentsListSort;
    }

    public List<Equipments> filterEquipementsByName(String dir, int page, int level, String name) throws IOException {
        List<Equipments> equipmentsList = this.deserialized(dir);

        equipmentsListSort = equipmentsList
                .stream()
                .filter(equipments -> Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(equipments.getName()).find())
                .filter(equipments -> Integer.parseInt(equipments.getLvl()) <= level)
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());

        return equipmentsListSort;
    }

    public List<Equipments> filterEquipementsByStat(String dir, int page, int level, Predicate<Statistic> predicate) throws IOException {
        List<Equipments> equipmentsList;
        if(equipmentsListSort != null) {
            equipmentsList = equipmentsListSort;
        } else {
            equipmentsList = this.deserialized(dir);
        }
        equipmentsListSort = equipmentsList
                .stream()
                .filter(equipments -> equipments.getStats().stream().anyMatch(predicate))
                .filter(equipments -> Integer.parseInt(equipments.getLvl()) <= level)
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());

        return equipmentsListSort;
    }

    public List<Equipments> reversedEquipements() {
        equipmentsListSort = equipmentsListSort.stream().sorted(Comparator.comparingInt((Equipments e) -> Integer.parseInt(e.getLvl()))).collect(toListReversed());
        return equipmentsListSort;
    }

    private static <T> Collector<T, ?, List<T>> toListReversed() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }
}
