package by.it.sheremet.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
       // list.remove(1);
        //System.out.println(list);

        list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        //list.remove(1);
        //System.out.println(list);

        List<String> list1 = new ArrayList<>();
        list1.add("six");
        list1.add("seven");
        list1.add("eight");
        list1.add("nine");
        list1.add("ten");
        System.out.println(list1);

        list1 = new ListB<>();
        list1.add("six");
        list1.add("seven");
        list1.add("eight");
        list1.add("nine");
        list1.add("ten");
        System.out.println(list1);
    }
}
