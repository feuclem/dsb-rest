package com.dsb.rest.dao;

import com.dsb.rest.model.Equipments;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class EquipementsDAOTest {
    private EquipementsDAO amulettesController = new EquipementsDAO();
    private String dir = "src/main/resources/amulettes.json";

    @Test
    public void getAllAmulettesPage1ShouldReturn1To50Elements() throws IOException {
        // Given
        int page = 1;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Amulette Volkorne");
        Assert.assertEquals(result.get(0).getLvl(), "200");
        Assert.assertEquals(result.get(0).getStats().get(0).getVitalite().getFrom(), "301");
        Assert.assertEquals(result.get(0).getStats().get(0).getVitalite().getTo(), "400");
        Assert.assertEquals(result.get(0).getStats().get(1).getIntelligence().getFrom(), "81");
        Assert.assertEquals(result.get(0).getStats().get(1).getIntelligence().getTo(), "100");
        Assert.assertEquals(result.get(49).getName(), "Amulette de Danathor");
        Assert.assertEquals(result.get(49).getLvl(), "194");
    }

    @Test
    public void getAllAmulettesPage2ShouldReturn51To100Elements() throws IOException {
        // Given
        int page = 2;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Kralamansion");
        Assert.assertEquals(result.get(0).getLvl(), "194");
        Assert.assertEquals(result.get(49).getName(), "Insigne de Keukeuf");
        Assert.assertEquals(result.get(49).getLvl(), "106");
    }

    @Test
    public void getAllAmulettesPage3ShouldReturn100To149Elements() throws IOException {
        // Given
        int page = 3;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Ouassulette");
        Assert.assertEquals(result.get(0).getLvl(), "105");
        Assert.assertEquals(result.get(49).getName(), "Amulette d'Hichète");
        Assert.assertEquals(result.get(49).getLvl(), "57");
    }

    @Test
    public void getAllAmulettesPage4ShouldReturn150To200Elements() throws IOException {
        // Given
        int page = 4;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Amuloumulette");
        Assert.assertEquals(result.get(0).getLvl(), "57");
        Assert.assertEquals(result.get(49).getName(), "Amulette de Rapiat");
        Assert.assertEquals(result.get(49).getLvl(), "42");
    }

    @Test
    public void getAllAmulettesPage5ShouldReturn201To250Elements() throws IOException {
        // Given
        int page = 5;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Amulette de Gobeuf");
        Assert.assertEquals(result.get(0).getLvl(), "42");
        Assert.assertEquals(result.get(49).getName(), "Amulette en Crabe");
        Assert.assertEquals(result.get(49).getLvl(), "24");
    }

    @Test
    public void getAllAmulettesPage6ShouldReturn251To300Elements() throws IOException {
        // Given
        int page = 6;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Entente");
        Assert.assertEquals(result.get(0).getLvl(), "23");
        Assert.assertEquals(result.get(49).getName(), "Amulette de Mini-Miss Amakna");
        Assert.assertEquals(result.get(49).getLvl(), "1");
    }

    @Test
    public void getAllAmulettesPage7ShouldReturn301ToXXXElements() throws IOException {
        // Given
        int page = 7;

        // When
        List<Equipments> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 9);
        Assert.assertEquals(result.get(0).getName(), "Amulette de Miss Monde des Douze");
        Assert.assertEquals(result.get(0).getLvl(), "1");
        Assert.assertEquals(result.get(8).getName(), "Koliet Aclou");
        Assert.assertEquals(result.get(8).getLvl(), "1");
    }

    @Test
    public void filterByLevel() throws IOException {
        // When
        List<Equipments> result = amulettesController.filterEquipementsByLevel(dir, 1, 200);

        // Then
        Assert.assertEquals(result.size(), 50);
    }

    @Test
    public void filterByName() throws IOException {
        // When
        List<Equipments> result = amulettesController.filterEquipementsByName(dir, 1, 200, "hibou");

        // Then
        Assert.assertEquals(result.size(), 2);
    }
}