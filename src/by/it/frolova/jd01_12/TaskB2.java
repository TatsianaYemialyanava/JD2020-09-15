package by.it.frolova.jd01_12;

import java.util.*;

/* TaskB2. Считалка. В кругу стоят N человек.
 При ведении счета по кругу итератором вычеркивается каждый второй человек,
пока не останется один.
 Нужно составить два метода, моделирующие процесс и возвращающие имя
оставшегося человека:
static String process(ArrayList<String> peoples)
static String process(LinkedList<String> peoples)
 Покажите работу методов в main*/
public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> namesArray = new ArrayList<>();
        LinkedList<String> namesLinked = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String name = sc.next();
            namesArray.add(name);
        }

        for (int i = 0; i < num; i++) {
            String name = sc.next();
            namesLinked.add(name);
        }

        System.out.println(process(namesArray));
        System.out.println(process(namesLinked));
    }

    static String process(ArrayList<String> peoples) {

        return clearSecond(peoples);
    }

    static String process(LinkedList<String> peoples) {

        return clearSecond(peoples);
    }


    static String clearSecond(List<String> names) {
        int index = 1;
        while (names.size() > 1) {
            Iterator<String> iterator = names.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (index % 2 == 0) {
                    iterator.remove();
                }
                index++;
            }
        }
        String result = names.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("]", "");
        return result;
    }
}