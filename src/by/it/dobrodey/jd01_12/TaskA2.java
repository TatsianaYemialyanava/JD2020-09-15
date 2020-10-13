package by.it.dobrodey.jd01_12;

import java.util.*;

/*
    TaskA2. В main класса TaskA2 определите два множества (a и b) на основе
    целых чисел.
     Создайте статические методы для определения пересечения множеств getCross
    и объединения множеств getUnion.
     Покажите работу этих методов на примере двух разных множеств (например,
    HashSet a и TreeSet b).

 */
public class TaskA2 {
    public static void main(String[] args) {
        List<Integer>list1 = Arrays.asList(1,6,8,5,8,6,4,5,7,5,64);
        List<Integer>list2 = Arrays.asList(2,6,7,4,8,6,8,10,3,5,64);
        Set<Integer> a = new HashSet<>(list1);
        Set<Integer> b = new TreeSet<>(list2);
        System.out.println("a="+a);
        System.out.println("b="+b);
        Set<Integer> union= getUnion(a, b);
        System.out.println("union="+union);
        Set<Integer> cross= getCross(a,b);
        System.out.println("cross = "+ cross);
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;

    }
}
