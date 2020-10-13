package by.it.dobrodey.jd01_12;

import java.util.*;

/*
 TaskC2. Попробуйте решить заново задачу TaskA2 для любого количества множеств на входе метода,
 а также для различных типов чисел в множествах (generics). Например, на входе три множества Long, Byte, Float.
  Важно: сравнивать нужно значения. Например, считается, что 1L==1.0F
  В main покажите работоспособность решения.

 */
public class TaskC2 {
    public static void main(String[] args) {
        List<Double> list1 = Arrays.asList(1.0, 6.0, 8.0, 8.0);
        List<Long> list2 = Arrays.asList(2L, 6L, 4L, 8L, 6L, 8L);
        List<Integer> list3 = Arrays.asList(2, 6, 16, 8, 16, 8);
        List<Float> list4 = Arrays.asList(6F, 17F, 4F, 8F, 16F, 8F, 10F);
        Set<Double> a = new HashSet<>(list1);
        Set<Long> b = new HashSet<>(list2);
        Set<Integer> c = new HashSet<>(list3);
        Set<Float> d = new HashSet<>(list4);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
        System.out.println("d=" + d);
        Set<Double> union = getUnion(a, b, c,d);
        System.out.println("union=" + union);
        Set<Double> cross = getCross(a, b, c,d);
        System.out.println("cross = " + cross);
    }

    private static Set<Double> getCross(Set<?>... a) {
        Set<Double> result = new HashSet<>(getDouble(a[0]));
        for (int i = 1; i < a.length; i++) {
            result.retainAll(getDouble(a[i]));
        }
        return result;
    }

    private static Set<Double> getUnion(Set<?>... a) {
        Set<Double> result = new HashSet<>();
        for (Set<?> integers : a) {
          result.addAll(getDouble(integers));
            }
         return result;
    }

    private static Set<Double> getDouble(Set<?>a){
        String in=a.toString();
        in = in.replaceAll("[^0-9.,]","");
        String[] arr = in.split(",");
        Set<Double> result = new HashSet<>();
        for (String s : arr) {
            result.add(Double.parseDouble(s));
        }

        return result;
    }
}
