package bai8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    public static void readCities(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("files/cities.dat"));
            String line = reader.readLine();
            while (line != null) {
                City city=convertToCity(line);
//                System.out.println(city);
                DataCache.CITIES.put(city.id, city);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(DataCache.CITIES.size());
    }
    
    public static void readCountries(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("files/countries.dat"));
            String line = reader.readLine();
                while (line != null) {
                    Country country=convertToCountry(line);
                    DataCache.COUNREIES.put(country.code, country);
                    line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static City convertToCity(String line){
        City city=new City();
        Pattern pattern = Pattern.compile("([a-zA-Z]+)=([a-zA-Z0-9 .]+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String field = matcher.group(1);
            String value = matcher.group(2);
            switch (field){
                case "id": city.setId(Integer.parseInt(value));  break;
                case "name": city.setName(value); break;
                case "population": city.setPopulation(Integer.parseInt(value)); break;
                case "countryCode": city.setCountryCode(value); break;
            }
        }
        return city;
    }

    public static Country convertToCountry(String line){
        Country country=new Country();
        Pattern pattern = Pattern.compile("([a-zA-Z]+)=([a-zA-Z0-9 .]+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String field = matcher.group(1);
            String value = matcher.group(2);
            switch (field){
                case  "code" : country.setCode(value);break;
                case  "name" : country.setName(value);break;
                case  "continent" : country.setContinent(value);break;
                case  "surfaceArea" : country.setSurfaceArea(Double.parseDouble(value));break;
                case  "population" : country.setPopulation(Integer.parseInt(value));break;
                case  " gnp" : country.setGnp(Double.parseDouble(value)); break;
                case  "capital" :country.setCapital(Integer.parseInt(value)); break;
            }
        }
        return country;
    }
    public static void main(String[] args) {
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            ReadFile.readCities();
            ReadFile.readCountries();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
