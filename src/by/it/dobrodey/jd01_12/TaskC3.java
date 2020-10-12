package by.it.dobrodey.jd01_12;
/*
TaskC3. В консоль вводится строка, состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
 Проверьте и выведите в консоль корректность расстановки скобок (true или false) с помощью коллекций.
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String unput = sc.next();
        System.out.println(unput);
        Pattern pt = Pattern.compile("[\\{\\}\\(\\)\\[\\]]");
        Matcher mt = pt.matcher(unput);
        while (mt.find()) {
            String word = mt.group();
            if (map.containsKey(word)) {
                map.replace(word, map.get(word), map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);
        if ((map.get("(") == map.get(")")) && (map.get("[") == map.get("]")) && (map.get("{") == map.get("}"))) {
            System.out.println(true);
        } else System.out.println(false);
    }
}
