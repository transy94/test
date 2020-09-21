package bai8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Worker {

    public Map<String, List<City>> mappopolationmax(){
        Map<String,List<City>> map=new HashMap<>();
        for (City city: DataCache.CITIES.values()){
            String countryCode = city.getCountryCode();
            List<City> list = map.getOrDefault(countryCode, new ArrayList<>());
            list.add(city);
            map.put(countryCode,list);
        }
        return map;
    }
    public Map<String , List<City>> mapcontinent(){
        Map<String, List<City>> mapcontinent =new HashMap<>();
        Map<String, City> findCity = findCity();
        for (Country contry : DataCache.COUNREIES.values()){
           String continent = contry.getContinent();
           City city = findCity.get(contry.getCode());
           if(mapcontinent.containsKey(continent)){
               mapcontinent.get(continent).add(city);
           }else {
               List<City> list = new ArrayList<>();
               list.add(city);
               mapcontinent.put(continent, list);
           }
        }
        return  mapcontinent;
    }
    public Map<String, City> mapCapital() throws  Exception{
        Map<String, City> mapCapital = new HashMap<>();
        Map<String , List<City>> map = mappopolationmax();
        for( Country country : DataCache.COUNREIES.values()){
          String countryCode = country.getCode();
          int capitalId = country.getCapital();
          if (null==map.get(countryCode))
            continue;
          for (City city : map.get(countryCode)){
             if(capitalId == city.getId()){
                 mapCapital.put(countryCode,city);
                 break;
             }
          }
        }
        return mapCapital;
    }
    public Map<String, List<City>> mapContinentCapital() throws Exception {
        Map<String,List<City>> mapContinentcapital = new HashMap<>();
        Map<String, City> map = mapCapital();
        for(Country country : DataCache.COUNREIES.values()){
            String continent = country.continent;
            City city = mapCapital().get(country.getCode());
            if(mapContinentcapital.containsKey(continent)){
                mapContinentcapital.get(continent).add(city);
            }else{
                List<City> list1 = new ArrayList<>();
                list1.add(city);
                mapContinentcapital.put(continent,list1);

            }

        }
    return  mapContinentcapital;

    }
    public Map<String, Integer>mapSizeCity(){
        Map<String,Integer> mapsizecity = new LinkedHashMap<>();
        Map<String, List<City>> map = mappopolationmax();
        for (City city: DataCache.CITIES.values()){
            String countryCode = city.getCountryCode();
            int size = map.get(countryCode).size();
            mapsizecity.put(countryCode, size);
        }
        try {
            mapsizecity=mapsizecity.entrySet().stream()
                    .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) ->e1, LinkedHashMap::new));
        }catch (Exception e){

        }

        return mapsizecity;
    }
    public Map<String,Double> mapMatDoDanSo(){
        Map<String, Double> mapmatdodansso = new HashMap<>();
        for( Country country : DataCache.COUNREIES.values()){
            String countryCode = country.getCode();
          double dienTich = (1.0*country.getPopulation()/country.getSurfaceArea());
            if (country.getPopulation() != 0) {
                mapmatdodansso.put(countryCode, dienTich);
            }
        }
        try {
            mapmatdodansso=mapmatdodansso.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
        }catch (Exception e){

        }
        return mapmatdodansso;
    }

    public Map<String,City> sapxepCapitalOfContinent() throws Exception {
        Map<String,City> map3 = new HashMap<>();
        Map<String, List<City>> map = mapContinentCapital();
        for(Map.Entry<String, List<City>> entry : map.entrySet() ){
            if(entry.getValue().contains(null))
                continue;
            entry.getValue().sort((City ct1, City ct2)->{
                if(ct1.getPopulation() >= ct2.getPopulation()){
                    return -1;
                }
                return 1;
                    });
            map3.put(entry.getKey(), entry.getValue().get(0));
        }
     return  map3;
    }
    public Map<String,City>sapxepCapital() throws  Exception{
      Map<String,City> map2 = new LinkedHashMap<>(mapCapital());
        try {
            map2=map2.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
        }catch (Exception e){

        }

        return map2;
    }

    public Map<String, City> sapXepContinent(){
     Map<String , City> map1 = new HashMap<>();
     Map<String, List<City>> map = mapcontinent();
     for ( Map.Entry<String,List<City>> entry : map.entrySet()){
         if(entry.getValue().contains(null))
             continue;
         entry.getValue().sort((City ct1, City ct2)-> {
             if( ct1.getPopulation()>= ct2.getPopulation()){
                 return -1;
             }else {
                 return 1;
             }
         });
         map1.put(entry.getKey(), entry.getValue().get(0));
     }
     return  map1;
    }
    public Map<String, City> findCity(){
        Map<String, City> map0= new HashMap<>();
        Map<String, List<City>> map = mappopolationmax();
        for (Map.Entry<String, List<City>>entry : map.entrySet()){
            if (entry.getValue().size()==0)
                continue;
            entry.getValue().sort((City city1, City city2)->{
                if (city1.getPopulation()>=city2.getPopulation())
                    return -1;
                else return 1;
            });
            map0.put(entry.getKey(), entry.getValue().get(0));
        }
        return map0;
    }
    public static void main(String[] args) {
        try {
            ReadFile.readCities();
            ReadFile.readCountries();
            Worker worker = new Worker();
            Map<String, City> map= worker.findCity();
            Map<String, City> map1 = worker.sapXepContinent();
            Map<String, City> map2 = worker.sapxepCapital();
            Map<String,City> map3 =worker.sapxepCapitalOfContinent();
            Map<String,Integer> map4 = worker.mapSizeCity();
            Map<String,Double> map5 = worker.mapMatDoDanSo();
            for( Map.Entry<String, City> entry : map2.entrySet()){
                System.out.println("thu do dong dan nhat : "+entry.getKey()
                        +" "+ entry.getValue());
                break;
            }
        System.out.println("thanh pho dong nhat nhat mojt quoc gia : " + map);
        System.out.println("thanh pho dong dan nhat luc dia : "+map1);
            System.out.println("thu do dong dan nhat luc dia : "+ map3);
           System.out.println("SL thanh pho cua 1 quoc gia : "+ map4);
           System.out.println("Mat do dan so cau cac quoc gia : "+ map5);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
