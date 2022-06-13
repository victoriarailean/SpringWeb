package com.example.fasttrackIT;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController


public  class Controller {

    CountryService countryService;

    public Controller(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("countries")
    @GetMapping("/all")
    public String readLine() throws Exception {
        return countryService.parseCoutries().toString();

    }

    @GetMapping("{id}/capital")
    public String nameCapial(@PathVariable int id) throws Exception {
        return countryService.parseCoutries().get(id).getCapital();
    }

    @GetMapping("/names")
    public String returnName() throws Exception {
        List<String> listName = new ArrayList<>();
        for (Country p : countryService.parseCoutries()) {
            listName.add(p.getName());

        }
        return listName.toString();
    }


    @GetMapping("{id}/population")
    public long numberPopulatio(@PathVariable int id) throws Exception {
        String p = String.valueOf(countryService.parseCoutries().get(id).getPopulation());
        long l = Long.parseLong(p);
        return l;
    }

    @GetMapping("/continent/{name}/countries")
    public String numberPopulatio(@PathVariable String name, @RequestParam(required = false) Long minPopulation ) throws Exception {
        List<String> country = new ArrayList<>();
        for (Country p : countryService.parseCoutries()) {
            if (p.getContinent().equals(name)) {
                if (minPopulation != null ){
                    if(Long.parseLong(p.getPopulation()) > minPopulation){
                        country.add(p.getName());
                    }
                }else{
                    country.add(p.getName());
                }
            }
        }

        return country.toString();
    }

    @GetMapping("/continent/{id}/neighbours")
    public String nameNeighbours(@PathVariable int id) throws Exception {
        return countryService.parseCoutries().get(id).getNeighbour();
    }

    @GetMapping("/countries/population")
    public Map<String, Long> population() throws Exception {
        Map<String, Long> population =new HashMap<>();
        for (Country p : countryService.parseCoutries()){
            population.put(p.getName(), p.getPopulation());
        }
        return population;
    }




}









