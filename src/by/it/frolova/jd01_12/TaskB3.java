package by.it.frolova.jd01_12;

/*TaskB3. Скопируйте предыдущую задачу и измерьте на размере задачи в 4096
элемент какой из двух методов работает быстрее. Объясните итог.
 Подумайте, как можно было бы решить задачу в методе
prоcess(LinkedList<String> peoples) без итератора и снижения
быстродействия, используя интерфейсы очередей. Проверьте свою идею.*/

import java.util.*;

public class TaskB3 {
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

        long time1 = System.nanoTime();
        String nameArray = process(namesArray);
        double delta1 = System.nanoTime() - time1;
        long time2 = System.nanoTime();
        String nameLinked = process(namesLinked);
        double delta2 = System.nanoTime() - time2;

        System.out.printf("%s %s %f\n", "ArrayList:", nameArray, delta1);
        System.out.printf("%s %s %f", "LinkedList:", nameLinked, delta2);
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


