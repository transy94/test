package bai8;

import java.util.HashMap;
import java.util.Map;

public class DataCache {
    public static Map<Integer, City> CITIES;
    public static Map<String, Country> COUNREIES;
    static {
        DataCache.CITIES = new HashMap<>();
        DataCache.COUNREIES = new HashMap<>();
    }
}
