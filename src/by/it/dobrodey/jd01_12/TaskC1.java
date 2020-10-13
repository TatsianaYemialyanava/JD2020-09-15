package by.it.dobrodey.jd01_12;

import java.util.*;

/*
 TaskC1. Нужно ввести с консоли текст до строки end. Во входном тексте  хранятся наименования некоторых объектов,
 по одному в строке. Строки иногда повторяются.
  Построить ассоциативный массив C, элементы которого содержат наименования (значения) и уникальные шифры (ключи)
  данных объектов, причем элементы списка должны быть упорядочены по возрастанию шифров (шифр – некоторое случайное,
  но гарантированно уникальное число).
   Выведите полученный ассоциативный массив в консоль методом toString()
   Затем нужно «сжать» список C, удаляя дублирующийся наименования объектов (оставляйте первое вхожение наименования,
  остальные – удаляются).
   Выведите полученный ассоциативный массив в консоль методом toString()

 */
public class TaskC1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        Map<Integer, String> mapHash = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int code = 0;
        for (; ; ) {
            String s = sc.next();
            String input = s.replaceAll("([^A-Za-z']+)", "").trim();
            if (input.equals("end")) {
                break;
            }
            if (input.length()>0){
            map.put(code = code + 1, input);
            if (!mapHash.containsValue(input)) {
                mapHash.put(code,input);
            }
        }}
        System.out.println(map.toString());
        System.out.println(mapHash.toString());

    }
}




