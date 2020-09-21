package bai3;

import com.sun.org.apache.bcel.internal.ExceptionConst;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static List<String> nameFile() {
        List<String> list = new ArrayList<>();
        File folder = new File("input_3");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File " + file.getName());
                list.add(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory " + file.getName());
            }
        }
        return list;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        List<Future<Map>> list = new ArrayList<>();
        List<String> listFileName = nameFile();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (String filename : listFileName) {
            Callable<Map> callable = new CallableWorker(filename);
            Future<Map> future = executorService.submit(callable);
            list.add(future);
        }
        Map<String,Integer> mapfuture = new HashMap<>();
        for(Future<Map> f : list){
            Map<String,Integer> map =f.get();
            for (Map.Entry<String,Integer> entry: map.entrySet()){
                if (mapfuture.containsKey(entry.getKey()))
                {
                    int count = mapfuture.get(entry.getKey())+entry.getValue();
                    mapfuture.put(entry.getKey(), count);
                }else
                    mapfuture.put(entry.getKey(), entry.getValue());
            }
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        try {
           mapfuture = mapfuture.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()).collect(toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Integer> map1 = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : mapfuture.entrySet()) {
            map1.put(entry.getKey(), entry.getValue());
            if (map1.size() > 9) {
                break;
            }
        }
        try {
            mapfuture = mapfuture.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Integer> map2 = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : mapfuture.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
            if (map2.size() > 9) {
                break;
            }
        }
        System.out.println("10 tu xuat hien it nhat :"+map1);
        System.out.println("10 tu xuat hien nhieu nhat :"+map2);
        System.out.println(mapfuture.size());


    }
}
