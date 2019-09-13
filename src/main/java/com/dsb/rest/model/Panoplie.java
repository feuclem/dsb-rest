package com.dsb.rest.model;

import java.util.List;

public class Panoplie {
    private int _id;
    private String name;
    private String lvl;
    private List<Bonus> bonus;
    private List<Integer> equipment_id;
    private List<Integer> weapon_id;
    private List<Equipments> equipments;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public List<Bonus> getBonus() {
        return bonus;
    }

    public void setBonus(List<Bonus> bonus) {
        this.bonus = bonus;
    }

    public List<Integer> getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(List<Integer> equipment_id) {
        this.equipment_id = equipment_id;
    }

    public List<Equipments> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipments> equipments) {
        this.equipments = equipments;
    }

    public List<Integer> getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(List<Integer> weapon_id) {
        this.weapon_id = weapon_id;
    }
}

class Bonus {
    private int number;
    private List<Statistic> stats;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Statistic> getStats() {
        return stats;
    }

    public void setStats(List<Statistic> stats) {
        this.stats = stats;
    }
}
