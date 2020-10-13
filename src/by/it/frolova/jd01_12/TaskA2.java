package by.it.frolova.jd01_12;

/*В main класса TaskA2 определите два множества (a и b) на основе
целых чисел.
 Создайте статические методы для определения пересечения множеств getCross
и объединения множеств getUnion.
 Покажите работу этих методов на примере двух разных множеств (например,
HashSet a и TreeSet b).*/

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] arrayA = {1, 2, 5, 6, 3, 8, 9, 4, 8};
        List<Integer> listA = Arrays.asList(arrayA);
        Set<Integer> setA = new HashSet(listA);

        Integer[] arrayB = {3, 6, 100, 4, 8};
        List<Integer> listB = Arrays.asList(arrayB);
        Set<Integer> setB = new TreeSet<>(listB);

        Set<Integer> cross = getCross(setA, setB);
        System.out.println("set A: " + setA);
        System.out.println("set B: " + setB);
        System.out.println("crossed: " + cross);

        Set<Integer> union = getUnion(setA, setB);
        System.out.println("united: " + union);
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> set = new HashSet<>(set1);
        set.retainAll(set2);
        return set;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        TreeSet<Integer> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }
}
