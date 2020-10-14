package by.it.sheremet.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> names1 = new ArrayList<String>();
        LinkedList<String> names2 = new LinkedList<String>();
        for (int i = 0; i < 4096; i++) {

            names1.add(String.valueOf(i));
            names2.add(String.valueOf(i));
        }

        Long t = System.nanoTime();
        String name1 = process(names1);
        Long tA = System.nanoTime() - t;
        System.out.println(name1);
        Long t1 = System.nanoTime();
        String name2 = process(names2);
        Long tL = System.nanoTime() - t1;
        System.out.println(name2);
        System.out.println(" Время работы для  ArrayList=" + tA / 1000 + " мкс.");
        System.out.println(" Время работы для  LinkedList=" + tL / 1000 + " мкс.");
    }

    static String process(ArrayList<String> peoples) {
        int n = 0;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            while (iterator.hasNext()){
                iterator.next();
                if(n==1){
                    iterator.remove();
                    n = 0;
                    continue;
                }
                n=1;
            }
            iterator = peoples.iterator();
        }
        String result = peoples.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("\\]", "");
        return result;
    }


    static String process(LinkedList<String> peoples) {
        int n = 0;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            while (iterator.hasNext()){
                iterator.next();
                if(n==1)
                {
                    iterator.remove();
                    n = 0;
                    continue;
                }
                n=1;
            }
            iterator = peoples.iterator();
        }
        String result = peoples.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("\\]", "");
        return result;
    }
}
