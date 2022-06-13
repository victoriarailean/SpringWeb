package com.example.fasttrackIT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountryService {


    public CountryService() {
    }

    public List<Country> parseCoutries() throws Exception {

        List<Country> listCountries = new ArrayList<>();

        File file = new ClassPathResource("data.txt").getFile();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
           String [] parsedLine = line.split("\\|");
           String neighbour = null;
           if(parsedLine.length > 5){
               neighbour = parsedLine[5];
           }
           Country country = new Country(parsedLine[0], parsedLine[1], parsedLine[2], parsedLine[3], parsedLine[4], neighbour);
           listCountries.add(country);

        }
        fr.close();

        return listCountries;
    }

}


