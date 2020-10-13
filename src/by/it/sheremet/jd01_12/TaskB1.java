package by.it.sheremet.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        for (; ; ) {
            String input = sc.next();
            String word = input.replaceAll("([^A-Za-z']+)", "");

            if (word.equals("end")) {
                break;
            }
            if(word.length()>0){
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
                else {
                    map.put(word, 1);
                }
            }
        }

        System.out.println(map);
    }
}