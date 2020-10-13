package by.it.dobrodey.jd01_12;
/*
 TaskB3. Скопируйте предыдущую задачу и измерьте на размере задачи в 4096 элемент какой из двух методов работает
  быстрее. Объясните итог.  Подумайте, как можно было бы решить задачу в методе prоcess(LinkedList<String> peoples)
   без итератора и снижения быстродействия, используя интерфейсы очередей. Проверьте свою идею.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

    public static void main(String[] args) {
        ArrayList<String> peopleList1 = new ArrayList<>();
        LinkedList<String> peopleList2 = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {

            peopleList1.add(String.valueOf(i));
            peopleList2.add(String.valueOf(i));
        }

        System.out.println(peopleList1);
        System.out.println(peopleList2);
        Long t = System.nanoTime();
        String name1 = process(peopleList1);
        Long tA = System.nanoTime() - t;
        System.out.println("name1 = " + name1);
        Long t1 = System.nanoTime();
        String name2 = process(peopleList2);
        Long tL = System.nanoTime() - t1;
        System.out.println("name2 = " + name2);
        System.out.println(" Время работы для  ArrayList=" + tA / 1000 + " мкс.");
        System.out.println(" Время работы для  LinkedList=" + tL / 1000 + " мкс.");
    }

    static String process(ArrayList<String> peoples) {
        int n = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() != 1) {
            while (it.hasNext()){
                it.next();
                if(n==1){it.remove();n = 0;continue;}
                n=1;
            }
            it = peoples.iterator();
        }
        String result = peoples.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("]", "");
        return result;
    }


    static String process(LinkedList<String> peoples) {
        int n = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() != 1) {
            while (it.hasNext()){
                it.next();
                if(n==1){it.remove();n = 0;continue;}
                n=1;
            }
            it = peoples.iterator();
        }
        String result = peoples.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("]", "");
        return result;
    }
}




