package by.it.kolesnikov.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List <String> list = new ArrayList<>();
        for (;;){
            String input = sc.next();
            String word = input.replaceAll("[^a-zA-Z']", "").trim();
            if(word.equals("end")) {
                break;
            }
            list.add(word);
        }
        Set <String> set = new HashSet<>(list);
        for (String el : set){
            System.out.println(el+"="+Collections.frequency(list, el));
        }
    }
}
