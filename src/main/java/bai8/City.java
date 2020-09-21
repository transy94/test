package bai8;

import org.jetbrains.annotations.NotNull;

public class City implements Comparable<City> {
    int id;
    String name;
    int population;
    String countryCode;

    public City() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    City (int id, String name, int population ,String countryCode){
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }


    @Override
    public int compareTo(@NotNull City o) {
        return this.population>=o.getPopulation()?-1: 1;
    }
}
