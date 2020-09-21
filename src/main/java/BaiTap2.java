import java.io.*;
import java.util.*;

public class BaiTap2 {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TRAN SY\\Desktop\\New folder\\input_2\\xyzzzz.txt"));
            String line = bufferedReader.readLine();
            Map<String, Integer> map = new HashMap<>();
            while ((line)!= null){
                StringTokenizer stringTokenizer = new StringTokenizer(line," .,!=+-",false);
                while (stringTokenizer.hasMoreTokens()){
                    String token = stringTokenizer.nextToken();
                    System.out.println(token);
                    if(map.containsKey(token)){
                        int valueInMap = map.get(token);
                        valueInMap += 1;
                        map.put(token,valueInMap);
                    }else {
                        map.put(token,1);
                    }
                }
                line = bufferedReader.readLine();
                }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output2.txt"));
            map.forEach((s,integer) -> {
                try {
                    bufferedWriter.append(s +" " + integer+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
