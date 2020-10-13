package by.it.dobrodey.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

/*
TaskB1. Нужно ввести с консоли текст на английском языке до строки “end” (100 и
более слов).
 Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
 Вывести все различные слова формате слово=частота. Слова, отличающиеся
регистром букв, считать различными. isn't или don’t – одно слово.

 */
public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        for (; ; ) {
            String unput = sc.next();
            String s = unput.replaceAll("([^A-Za-z']+)", "");
            s=s.trim();

            if (s.equals("end")) {break;}
            if(s.length()>0){
            if (map.containsKey(s)) {
                map.replace(s, map.get(s), map.get(s) + 1);
            }
            else {map.put(s, 1);}
        }}

        System.out.println(map);
    }
}
