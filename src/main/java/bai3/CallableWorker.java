package bai3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.*;
import java.util.concurrent.Callable;
public class CallableWorker implements Callable<Map>  {
    String filename;
    public CallableWorker(String fileName) {
        this.filename = fileName;
    }
    @Override
    public Map call() throws Exception {
        Map<String,Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("input_3//" + filename));
        String line = reader.readLine();
        StringBuffer stringBuffer = new StringBuffer();
        while (line != null) {
            stringBuffer.append(line);
            line = reader.readLine();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(), " \uFEFF.+-,=;:[]!_%)'(?", false);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken().toLowerCase();
            synchronized (map){
                if (map.containsKey(token)){
                    int value1 = map.get(token);
                    value1+=1;
                   map.put(token,value1);
                }else{
                  map.put(token,1);
                }
            }
        }
        reader.close();
        return map;

    }


}
