package com.dsb.rest.dao;

import com.dsb.rest.model.Equipments;
import com.dsb.rest.model.FilterForm;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class AmulettesDAO {
    private static final int pageSize = 50;

    private List<Equipments> deserialized() throws FileNotFoundException {
        String dir = "src/main/resources/amulettes.json";
        Equipments[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Equipments[].class);
        return Arrays.asList(el);
    }

    public List<Equipments> filterAmulettes(int page, FilterForm filterForm) throws FileNotFoundException {
        List<Equipments> equipmentsList = this.deserialized();
        return equipmentsList
                .stream()
                .filter(equipments -> equipments.getLvl().equals(filterForm.getLvl()))
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public List<Equipments> getAllAmulettes(int page) throws FileNotFoundException {
        List<Equipments> equipmentsList = this.deserialized();
        equipmentsList = equipmentsList.stream().sorted(Comparator.comparingInt((Equipments e) -> Integer.parseInt(e.getLvl()))).collect(toListReversed());
        return equipmentsList.stream().skip(pageSize * (page - 1)).limit(pageSize).collect(Collectors.toList());
    }

    private static <T> Collector<T, ?, List<T>> toListReversed() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }
}
