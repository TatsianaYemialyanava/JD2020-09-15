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

        ListB<String> lister = new ListB<>();
        lister.add("1");
        lister.add("2");
        lister.add("3");
        lister.add("4");
        ListB<String> lister2 = new ListB<>();
        lister2.add("5");
        lister2.add("6");
        lister2.add("7");
        lister2.add("8");
        lister.addAll(lister2);
        System.out.println(lister);

    }
}
