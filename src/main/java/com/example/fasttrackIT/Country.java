package com.example.fasttrackIT;
import org.springframework.stereotype.Service;

@Service
    public class Country {

    private  String name;
    private  String capital;
    private  String population;
    private  String area;
    private  String continent;
    private  String neighbour;

    public Country(String name, String capital, String population, String area, String continent, String neighbour){
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent= continent;
        this.neighbour = neighbour;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public String getNeighbour() {
        return neighbour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setNeighbour(String neighbour) {
        this.neighbour = neighbour;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population='" + population + '\'' +
                ", area='" + area + '\'' +
                ", continent='" + continent + '\'' +
                ", neighbour='" + neighbour + '\'' +
                '}';
    }
}
