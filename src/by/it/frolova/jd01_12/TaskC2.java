package by.it.frolova.jd01_12;

/*Попробуйте решить заново задачу TaskA2 для любого количества
множеств на входе метода, а также для различных типов чисел в множествах
(generics). Например, на входе три множества Long, Byte, Float.
 Важно: сравнивать нужно значения. Например, считается, что 1L==1.0F
 В main покажите работоспособность решения.*/

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        List<Double> list1 = Arrays.asList(1.0, 6.0, 8.0, 8.0);
        List<Long> list2 = Arrays.asList(2L, 6L, 4L, 8L, 6L, 8L);
        List<Integer> list3 = Arrays.asList(2, 6, 16, 8, 16, 8);
        List<Float> list4 = Arrays.asList(6F, 17F, 4F, 8F, 16F, 8F, 10F);
        Set<Double> doubles = new HashSet<>(list1);
        Set<Long> longs = new HashSet<>(list2);
        Set<Integer> integers = new HashSet<>(list3);
        Set<Float> floats = new HashSet<>(list4);
        Set<? extends Number> union = getUnion(doubles, integers, floats, longs);
        System.out.println("united = " + union);
        Set<? extends Number> cross = getCross(doubles, integers, floats, longs);
        System.out.println("crossed = " + cross);
    }

    private static Set<Double> getCross(Set<? extends Number>... v) {
        Set<Double> result = toDoubleSet(v[0]);
        for (int i = 1; i < v.length; i++) {
            result.retainAll(toDoubleSet(v[i]));
        }
        return result;
    }

    private static Set<Double> getUnion(Set<? extends Number>... v) {
        Set<Double> result = toDoubleSet(v[0]);
        for (int i = 1; i < v.length; i++) {
            result.addAll(toDoubleSet(v[i]));
        }
        return result;
    }

    private static Set<Double> toDoubleSet(Set<? extends Number> numbers) {
        Set<Double> result = new HashSet<>();
        for (Number n : numbers) {
            result.add(n.doubleValue());
        }
        return result;
    }
}
