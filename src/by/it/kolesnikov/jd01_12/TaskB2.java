package by.it.kolesnikov.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
       ArrayList <String> peoples1 = new ArrayList<>();
       LinkedList <String> peoples2 = new LinkedList<>();
       String [] arr = {"Valera", "Julia", "Misha", "George", "Vasily", "Eugene"};
        for (String el : arr) {
            peoples1.add(el);
            peoples2.add(el);
        }
        System.out.println(peoples1);
        System.out.println(process(peoples1));
        System.out.println(peoples2);
        System.out.println(process(peoples2));
    }
    static String process (ArrayList<String> peoples){
        int count=0;
        Iterator<String> it = peoples.iterator();
        while(peoples.size()!=1){
            while (it.hasNext()){
                it.next();
                if(count==1) {
                    it.remove();
                    count=0;
                    continue;
                }
                count=1;
            }
            it = peoples.iterator();
        }
        String name = peoples.toString();
        name = name.replaceAll("\\[", "");
        name = name.replaceAll("]", "");
        return name;
    }

    static String process (LinkedList<String> peoples){
        int count=0;
        Iterator<String> it = peoples.iterator();
        while(peoples.size()!=1){
            while (it.hasNext()){
                it.next();
                if(count==1) {
                    it.remove();
                    count=0;
                    continue;
                }
                count=1;
            }
            it = peoples.iterator();
        }
        String name = peoples.toString();
        name = name.replaceAll("\\[", "");
        name = name.replaceAll("]", "");
        return name;
    }
}
