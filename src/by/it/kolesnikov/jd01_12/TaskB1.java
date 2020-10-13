package by.it.kolesnikov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List <String> list = new ArrayList<>();
        for (;;){
            String input = sc.next();
            if(input.equals("end")) {
                break;
            }
            list.add(input);
            Pattern pattern = Pattern.compile("[a-zA-Z']+");
            Matcher mt = pattern.matcher(input);
        }
        Set <String> set = new HashSet<>(list);
        for (String el : set){
            System.out.println(el+"="+Collections.frequency(list, el));
        }
    }
}
