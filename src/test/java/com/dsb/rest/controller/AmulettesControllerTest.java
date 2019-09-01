package com.dsb.rest.controller;

import com.dsb.rest.dao.AmulettesDAO;
import com.dsb.rest.model.Equipments;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class AmulettesControllerTest {

    private AmulettesController amulettesController = new AmulettesController(new AmulettesDAO());

    @Test
    public void getAllAmulettesPage1ShouldReturn1To50Elements() throws FileNotFoundException {
        // Given
        int page = 1;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Amulette Volkorne");
        Assert.assertEquals(result.get(0).getLvl(), "200");
        Assert.assertEquals(result.get(49).getName(), "Amulette de Danathor");
        Assert.assertEquals(result.get(49).getLvl(), "194");
    }

    @Test
    public void getAllAmulettesPage2ShouldReturn51To100Elements() throws FileNotFoundException {
        // Given
        int page = 2;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Kralamansion");
        Assert.assertEquals(result.get(0).getLvl(), "194");
        Assert.assertEquals(result.get(49).getName(), "Insigne de Keukeuf");
        Assert.assertEquals(result.get(49).getLvl(), "106");
    }

    @Test
    public void getAllAmulettesPage3ShouldReturn100To149Elements() throws FileNotFoundException {
        // Given
        int page = 3;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Ouassulette");
        Assert.assertEquals(result.get(0).getLvl(), "105");
        Assert.assertEquals(result.get(49).getName(), "Amulette d'Hichète");
        Assert.assertEquals(result.get(49).getLvl(), "57");
    }

    @Test
    public void getAllAmulettesPage4ShouldReturn150To200Elements() throws FileNotFoundException {
        // Given
        int page = 4;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Amuloumulette");
        Assert.assertEquals(result.get(0).getLvl(), "57");
        Assert.assertEquals(result.get(49).getName(), "Amulette de Rapiat");
        Assert.assertEquals(result.get(49).getLvl(), "42");
    }

    @Test
    public void getAllAmulettesPage5ShouldReturn201To250Elements() throws FileNotFoundException {
        // Given
        int page = 5;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Amulette de Gobeuf");
        Assert.assertEquals(result.get(0).getLvl(), "42");
        Assert.assertEquals(result.get(49).getName(), "Amulette en Crabe");
        Assert.assertEquals(result.get(49).getLvl(), "24");
    }

    @Test
    public void getAllAmulettesPage6ShouldReturn251To300Elements() throws FileNotFoundException {
        // Given
        int page = 6;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Entente");
        Assert.assertEquals(result.get(0).getLvl(), "23");
        Assert.assertEquals(result.get(49).getName(), "Amulette de Mini-Miss Amakna");
        Assert.assertEquals(result.get(49).getLvl(), "1");
    }

    @Test
    public void getAllAmulettesPage7ShouldReturn301ToXXXElements() throws FileNotFoundException {
        // Given
        int page = 7;

        // When
        List<Equipments> result = amulettesController.getAllAmulettes(page);

        // Then
        Assert.assertEquals(result.size(), 9);
        Assert.assertEquals(result.get(0).getName(), "Amulette de Miss Monde des Douze");
        Assert.assertEquals(result.get(0).getLvl(), "1");
        Assert.assertEquals(result.get(8).getName(), "Koliet Aclou");
        Assert.assertEquals(result.get(8).getLvl(), "1");
    }

    @Test
    public void filterAmulettes() throws FileNotFoundException {
        // When
        List<Equipments> result = amulettesController.filterAmulettes(1, 200);

        // Then
        Assert.assertEquals(result.size(), 35);
    }
}