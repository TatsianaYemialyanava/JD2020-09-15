package by.it.lapkovskiy.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next().replaceAll("[^-a-zA-Z']+","");
            if (input.equals("end")) {
                break;
            }
            if(map.containsKey(input))map.put(input,map.get(input)+1);
            else{ map.put(input,1); }
        }
        for (String m:map.keySet()) {
            System.out.println(m+"="+map.get(m));
        }
    }
}
