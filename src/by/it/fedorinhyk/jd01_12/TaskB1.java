package by.it.fedorinhyk.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> HashMap = new HashMap<>();
        for (; ; ) {
            String word = sc.next().replaceAll("[\\)\\(\\;\\.:,!?-]+", "");
            if (word.equals("end")) {
                break;
            }
            if (HashMap.containsKey(word)) HashMap.put(word, HashMap.get(word) + 1);
            else {
                HashMap.put(word, 1);
            }
        }
        for (String element : HashMap.keySet()) {
            System.out.println(element+"="+HashMap.get(element));
        }
    }
}
