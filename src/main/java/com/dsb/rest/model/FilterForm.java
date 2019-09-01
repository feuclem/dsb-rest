package com.dsb.rest.model;

public class FilterForm {
    private String lvl;

    public FilterForm(String lvl) {
        this.lvl = lvl;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
}
