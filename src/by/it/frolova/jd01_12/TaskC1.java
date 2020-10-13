package by.it.frolova.jd01_12;

/*Нужно ввести с консоли текст до строки end. Во входном тексте хранятся
наименования некоторых объектов, по одному в строке.
Строки иногда повторяются.
 Построить ассоциативный массив C, элементы которого содержат наименования
(значения) и уникальные шифры (ключи) данных объектов, причем элементы
списка должны быть упорядочены по возрастанию шифров (шифр – некоторое
случайное, но гарантированно уникальное число).
 Выведите полученный ассоциативный массив в консоль методом toString()
 Затем нужно «сжать» список C, удаляя дублирующийся наименования объектов
(оставляйте первое вхожение наименования, остальные – удаляются).
 Выведите полученный ассоциативный массив в консоль методом toString()*/

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> text = new TreeMap<>();
        Random rnd = new Random();

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                Integer key = rnd.nextInt();
                String value = input;
                while (!text.containsKey(key)) {
                    text.put(key, value);
                }
            }
        }
        System.out.println(text.toString());

        Collection<String> list = text.values();
        for(Iterator<String> itr = list.iterator(); itr.hasNext();) {
            if (Collections.frequency(list, itr.next()) > 1) {
                itr.remove();
            }
        }
        System.out.println(text.toString());
    }
}
