package com.dsb.rest.dao;

import com.dsb.rest.model.Equipment;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EquipementsDAOTest {
    private EquipementsDAO amulettesController = new EquipementsDAO();
    private String dir = "src/main/resources/equipements/amulettes.json";

    @Test
    public void getAllEquipementsTest() throws IOException {
        // Given
        int page = 1;

        // When
        List<Equipment> result = amulettesController.getAllEquipements(dir, page);

        // Then
        Assert.assertEquals(result.size(), 50);
        Assert.assertEquals(result.get(0).getName(), "Collier Lunaire");
    }

    @Test
    public void filterByLevel() throws IOException {
        // When
        List<Equipment> result = amulettesController.filterEquipementsByLevel(dir, 1, 200);

        // Then
        Assert.assertEquals(result.size(), 37);
        Assert.assertEquals(result.get(0).getName(), "Amulette Séculaire");
    }

    @Test
    public void filterByLevelShould() throws IOException {
        // When
        List<Equipment> result = amulettesController.filterEquipementsByLevel(dir, 1, 200);

        // Then
        Assert.assertEquals(result.size(), 37);
        Assert.assertEquals(result.get(0).getName(), "Amulette Séculaire");
    }

    @Test
    public void filterByName() throws IOException {
        // When
        List<Equipment> result = amulettesController.filterEquipementsByName(dir, 1, 200, "hibou");

        // Then
        Assert.assertEquals(result.size(), 2);
        Assert.assertEquals(result.get(0).getName(), "Pendentif du Hibou Chétif");
        Assert.assertEquals(result.get(1).getName(), "Amulette du Hibou");
    }

    @Test
    public void filterForStatsAddingFilter() throws IOException {
        // When
        List<Equipment> result = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force"));

        // Then
        Assert.assertEquals(result.size(), 50);

        // When
        List<Equipment> result2 = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force", "Agilite"));

        // Then
        Assert.assertEquals(result2.size(), 20);
    }

    @Test
    public void filterForStatsRemovingFilter() throws IOException {
        // Given
        amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force"));

        // When
        List<Equipment> result = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force", "Agilite"));

        // Then
        Assert.assertEquals(result.size(), 20);

        // When
        List<Equipment> result2 = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Agilite"));

        // Then
        Assert.assertEquals(result2.size(), 50);

        // When
        List<Equipment> result3 = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Agilite", "Chance"));

        // Then
        Assert.assertEquals(result3.size(), 19);
    }
}