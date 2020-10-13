package by.it.yemialyanava.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

public class TaskB2 {
    private static List<String> peoples;

    public static void main(String[] args) {
        String[] peopleArray = new String[]{"Катя", "Петя", "Павел", "Вася", "Коля", "Витя",
                "Света", "Маша","Филя", "Степашка"};
        peoples = new ArrayList<>(Arrays.asList(peopleArray));
        String lastHuman = process((ArrayList<String>) peoples);
        System.out.println(lastHuman);

        peoples = new LinkedList<>(Arrays.asList(peopleArray));
        String lastname = process((LinkedList<String>) peoples);
        System.out.println(lastname);
    }

    static String process(ArrayList<String> peoples) {
        if (peoples.size() == 1) {
            return peoples.get(0);
        }

        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1 && iterator.hasNext()) {
            iterator.next();
            boolean deleted = false;
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                deleted = true;
            }
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
                if (!deleted){
                    iterator.next();
                    iterator.remove();
                }
            }
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        if (peoples.size() == 1) {
            return peoples.get(0);
        }

        ListIterator<String> listIterator = peoples.listIterator();
        while (peoples.size() > 1 && listIterator.hasNext()) {
            listIterator.next();
            int howManyDeleted = 0;
            if (listIterator.hasNext()) {
                listIterator.next();
                listIterator.remove();
                howManyDeleted = 1;
            }
            if (!listIterator.hasNext()) {
                listIterator = peoples.listIterator();
                if (howManyDeleted ==0){
                    listIterator.next();
                    listIterator.remove();
                }
            }
        }
        return peoples.get(0);
    }
}

