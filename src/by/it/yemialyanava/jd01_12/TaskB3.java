package by.it.yemialyanava.jd01_12;

import java.util.*;

public class TaskB3 {
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
        LinkedList<String> tempPeople = new LinkedList<>();
        if (peoples.size() == 1) {
            return peoples.peek();
        }
        while (peoples.size() > 1) {

            tempPeople.add(peoples.poll());
            String secondDel = peoples.poll();
            if ( secondDel == null) { //последний удаленный элемент был нечетным и надо удалить  новую голову
                peoples = tempPeople;
                tempPeople = new LinkedList<>();
                peoples.poll();
            } else if (peoples.peek() != null){  //последний элемент был четным, но это конкретно последний элемент в коллекции
                peoples = tempPeople;
                tempPeople = new LinkedList<>();
            }
        }
        return peoples.peek();
    }

}
