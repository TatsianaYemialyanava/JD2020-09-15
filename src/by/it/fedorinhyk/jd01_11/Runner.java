package by.it.fedorinhyk.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> List = new ArrayList<>();
        List.add("one");
        List.add("two");
        List.add("three");
        List.add("four");
        List.add("five");
        System.out.println(List);
        List.remove(1);
        System.out.println(List);

        List=new ListA<>();
        List.add("one");
        List.add("two");
        List.add("three");
        List.add("four");
        List.add("five");
        System.out.println(List);
        List.remove(1);
        System.out.println(List);

        List=new ListB<>();
        List.add("one");
        List.add("two");
        List.add("three");
        List.add("four");
        List.add("five");
        System.out.println(List);
        List.remove(1);
        System.out.println(List);
    }
}
