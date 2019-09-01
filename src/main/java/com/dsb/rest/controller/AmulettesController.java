package com.dsb.rest.controller;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;

import com.dsb.rest.dao.AmulettesDAO;
import com.dsb.rest.model.Equipments;
import com.dsb.rest.model.FilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/amulettes")
public class AmulettesController {
    private final AmulettesDAO amulettesDao;

    public AmulettesController(AmulettesDAO amulettesDao) {
        this.amulettesDao = amulettesDao;
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Equipments> getAllAmulettes(@RequestParam int page) throws FileNotFoundException {
        return amulettesDao.getAllAmulettes(page);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public List<Equipments> filterAmulettes(@RequestParam int page, @RequestBody FilterForm filterForm) throws FileNotFoundException {
        return amulettesDao.filterAmulettes(page, filterForm);
    }
}
