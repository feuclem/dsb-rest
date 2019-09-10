package com.dsb.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://testdsb.herokuapp.com"})
@RequestMapping(path = "/panoplies")
public class PanopliesController {
    private final static String dir = "src/main/resources/panoplies.json";

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAllPanoplies() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileReader(dir), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
