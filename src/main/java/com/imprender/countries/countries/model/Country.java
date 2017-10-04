package com.imprender.countries.countries.model;

import java.util.List;

public class Country {

    private int id;
    private String name;
    private double population;
    private String capitalCity;
    private List<String> officialLanguages;
    private String flagImagePath;

    public Country(int id, String name, double population, String capitalCity, List<String> officialLanguages, String flagImagePath) {
        this.name = name;
        this.population = population;
        this.capitalCity = capitalCity;
        this.officialLanguages = officialLanguages;
        this.flagImagePath = flagImagePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPopulation() {
        return population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public List<String> getOfficialLanguages() {
        return officialLanguages;
    }

    public String getFlagImagePath() {
        return flagImagePath;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public void setOfficialLanguages(List<String> officialLanguages) {
        this.officialLanguages = officialLanguages;
    }
}
