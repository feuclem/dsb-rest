package com.dsb.rest.controller;

import com.dsb.rest.dao.EquipementsDAO;
import com.dsb.rest.model.Equipment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/boucliers")
public class BoucliersController {
    final static String dir = "src/main/resources/boucliers.json";
    private final EquipementsDAO equipementsDAO;

    public BoucliersController(EquipementsDAO equipementsDAO) {
        this.equipementsDAO = equipementsDAO;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipment> getAll(@RequestParam int page) throws IOException {
        return equipementsDAO.getAllEquipements(dir, page);
    }

    @GetMapping(path = "/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getTotal() throws IOException {
        return equipementsDAO.getTotalEquipement(dir);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipment> filter(@RequestParam int page, @RequestParam int level, @RequestParam(required = false) String name, @RequestParam(required = false) List<String> stats) throws IOException {
            return equipementsDAO.filter(dir, page, level, name, stats);
    }
}
