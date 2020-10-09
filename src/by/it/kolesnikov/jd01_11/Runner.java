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
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        List<String> lister = new ListA<>();
        lister.add("dog");
        lister.add("cat");
        lister.add("frog");
        lister.add("bird");
        System.out.println(lister);
        lister.remove(2);
        System.out.println(lister);
        System.out.println(lister.get(1));
    }
}
