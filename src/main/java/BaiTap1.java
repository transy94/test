import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaiTap1 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        for(int i = 10 ; i < 2000009; i ++){
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for ( int i = 1800000; i < 3799999; i++){
            set2.add(i);
        }
        long start1 = System.currentTimeMillis();
        set1.addAll(set2);
        long end1 = System.currentTimeMillis();
        long time1 = end1-start1;
        System.out.println(" thoi gian tim tap hop : " + time1);
        long start2 = System.currentTimeMillis();
        set1.retainAll(set2);
        long end2 = System.currentTimeMillis();
        long time2 = end2- start2;
        System.out.println(" thoi gian tim tap giao : " + time2);
        System.out.println("thoi gian tim hop va giao : " +(time1+time2));



    }

}
