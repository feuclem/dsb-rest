package com.dsb.rest.controller;

import com.dsb.rest.dao.AmulettesDAO;
import com.dsb.rest.model.Equipments;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/amulettes")
public class AmulettesController {
    private final AmulettesDAO amulettesDao;

    public AmulettesController(AmulettesDAO amulettesDao) {
        this.amulettesDao = amulettesDao;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipments> getAllAmulettes(@RequestParam int page) throws IOException {
        return amulettesDao.getAllAmulettes(page);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Equipments> filterAmulettes(@RequestParam int page, @RequestParam int level) throws IOException {
        return amulettesDao.filterAmulettes(page, level);
    }
}
