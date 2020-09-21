package baitap4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToaDo {
    int x;
    int y;
    @Override
    public String toString() {
        return "ToaDo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public ToaDo(){
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
     public static double khoangCach ( ToaDo toaDo1, ToaDo toaDo2){
        double kc = Math.sqrt(Math.pow(toaDo1.getX()-toaDo2.getX(),2)+(Math.pow(toaDo1.getY()-toaDo2.getY(),2)));
        return  kc;
    }
    public static int getRandom(Random random,int kc, int d){
        int rage = random.nextInt(2*kc)+ (d-kc);
        return rage;
    }
    public static void main(String[] args) throws IOException {
        ToaDo A = new ToaDo();
        A.x = 800;
        A.y = 800;
        ToaDo B = new ToaDo();
        B.x = 4000;
        B.y = 800;
        ToaDo C = new ToaDo();
        C.x = 2400;
        C.y = 2400;
        final int kcA = 400;
        final int kcB = 500;
        final int kcC= 600;
        Random random = new Random();
        Set<ToaDo> set1 = new HashSet<>();
        int rageA = 2*kcA;
        int minXA = A.getX()-kcA;
        int minYA = A.getY()- kcA;
        while (set1.size() < 8000) {
            ToaDo td = new ToaDo();
            td.x = random.nextInt(rageA)+minXA;
            td.y = random.nextInt(rageA)+minYA;
            if (khoangCach(td, A) <= 400) {
                set1.add(td);
            }

        }
        System.out.println(set1);
        Set<ToaDo> set2 = new HashSet<>();
        while (set2.size() < 10000) {
            ToaDo td = new ToaDo();
            td.x = getRandom(random,kcB,B.getX());
            td.y = getRandom(random,kcB,B.getY());
            if (khoangCach(td, B) <= 500) {
//                if(set1.contains(td)== false){
                set2.add(td);
//            }
            }
        }
        System.out.println(set2);
        Set<ToaDo> set3 = new HashSet<>();
        while (set3.size() < 12000) {
            ToaDo td = new ToaDo();
            td.x = getRandom(random,kcC,C.getX());
            td.y = getRandom(random,kcC,C.getY());
            if (khoangCach(td, C) <= 600) {
//                if(set1.contains(td)==false && set2.contains(td)==false){
                set3.add(td);
//            }
            }

        }
        System.out.println(set3);
        set1.addAll(set2);
        set1.addAll(set3);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files/output4.txt"));
            bufferedWriter.write(set1.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
       }
    }

}
