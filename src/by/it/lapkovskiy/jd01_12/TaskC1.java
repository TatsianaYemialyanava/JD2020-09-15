package by.it.lapkovskiy.jd01_12;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int pred=0;
        while (true){
            String input = sc.next().replaceAll("[^-a-zA-Z']+","");
            if (input.equals("end")) {
                break;
            }
            pred = random.nextInt(2)+pred+1;
            map.put(pred,input);
        }
        System.out.println(map.toString());
        Map<String,Integer> map2 = new HashMap<>();

        for (int m:map.keySet()) {
            if(!map2.containsValue(map.get(m)))
            map2.put(map.get(m),m);
        }
        map.clear();
        for (String m:map2.keySet()) {
                map.put(map2.get(m),m);
        }
        System.out.println(map.toString());

    }
}
