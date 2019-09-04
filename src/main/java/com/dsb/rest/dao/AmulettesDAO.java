package com.dsb.rest.dao;

import com.dsb.rest.model.Equipments;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class AmulettesDAO {
    private static final int pageSize = 50;

    private List<Equipments> deserialized() throws IOException {
        String dir = "src/main/resources/amulettes.json";
        ObjectMapper objectMapper = new ObjectMapper();
        Equipments[] equipments = objectMapper.readValue(new FileReader(dir), Equipments[].class);
        return Arrays.asList(equipments);
    }

    public List<Equipments> getAllAmulettes(int page) throws IOException {
        List<Equipments> equipmentsList = this.deserialized();
        equipmentsList = equipmentsList.stream().sorted(Comparator.comparingInt((Equipments e) -> Integer.parseInt(e.getLvl()))).collect(toListReversed());
        return equipmentsList.stream().skip(pageSize * (page - 1)).limit(pageSize).collect(Collectors.toList());
    }

    public List<Equipments> filterAmulettes(int page, int level) throws IOException {
        List<Equipments> equipmentsList = this.deserialized();
        return equipmentsList
                .stream()
                .filter(equipments -> Integer.parseInt(equipments.getLvl()) == level)
                .skip(pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    private static <T> Collector<T, ?, List<T>> toListReversed() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }
}
