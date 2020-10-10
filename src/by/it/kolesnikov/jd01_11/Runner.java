package by.it.kolesnikov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("cat");
        list.add("frog");
        list.add("bird");

        List<String> lister = new ArrayList<>();
        lister.add("1");
        lister.add("2");
        lister.add("3");
        lister.add("4");
        List<String> lister2 = new ArrayList<>();
        lister2.add("5");
        lister2.add("6");
        lister2.add("7");
        lister2.add("8");
        lister.addAll(lister2);
        System.out.println(lister);

        List<String> listik = new ListB<>();
        listik.add("dog");
        listik.add("cat");
        listik.add("frog");
        listik.add("bird");
        System.out.println(listik);
        listik.set(0, "shark");
        System.out.println(listik);
    }
}
