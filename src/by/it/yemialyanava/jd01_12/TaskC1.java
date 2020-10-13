package by.it.yemialyanava.jd01_12;
/*TaskC1. Нужно ввести с консоли текст до строки end. Во входном тексте хранятся
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
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s");
        Random rnd = new Random();
        Map<Integer, String > treeMap = new TreeMap<>();

        while(scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                Integer key = rnd.nextInt();
                while(!treeMap.containsKey(key)){
                    treeMap.put(key, input);
                }
            }
        }
        System.out.println(treeMap.toString());

        Map<Integer, String> map = new HashMap<>();
        for (Map.Entry<Integer,String> e : treeMap.entrySet()) {
            if(!map.containsValue(e.getValue())){
                map.put(e.getKey(),e.getValue());
            }
        }
        System.out.println(map.toString());
    }
}
