package com.dsb.rest.controller;

import com.dsb.rest.dao.EquipementsDAO;
import com.dsb.rest.model.Equipments;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://testdsb.herokuapp.com"})
@RequestMapping(path = "/boucliers")
public class BoucliersController {
    final static String dir = "src/main/resources/boucliers.json";
    private final EquipementsDAO equipementsDAO;

    public BoucliersController(EquipementsDAO equipementsDAO) {
        this.equipementsDAO = equipementsDAO;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipments> getAllBoucliers(@RequestParam int page) throws IOException {
        return equipementsDAO.getAllEquipements(dir, page);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipments> filterBoucliers(@RequestParam int page, @RequestParam int level) throws IOException {
        return equipementsDAO.filterEquipements(dir, page, level);
    }
}
