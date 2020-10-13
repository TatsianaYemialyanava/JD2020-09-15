package by.it.lapkovskiy.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {

        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));
        System.out.printf("a=%s\n", a);
        System.out.printf("b=%s\n", b);
        System.out.printf("c=%s\n", c);
        System.out.printf("d=%s\n", d);
        System.out.println(getUnion((new Set[]{a, b, b, c, c, d})));
        System.out.println(getCross((new Set[]{a, a, b, c, c, d})));
    }

    public static Set<?> getUnion(Set<?>... set) {
        HashSet<Double> result = new HashSet<>();
        for (int i = 0; i < set.length; i++) {
            for (Object e : set[i]) {
                if (e.getClass() == Double.class) result.add((Double) e);
                if (e.getClass() == Integer.class) result.add(Double.valueOf((Integer) e));
                if (e.getClass() == Long.class) result.add(Double.valueOf((Long) e));
            }
        }

        return result;
    }

    public static Set<?> getCross(Set<?>... set) {
        Set<Double> result = new HashSet<>();

        result.addAll(makeDouble(set[0]));
        for (int i = 1; i < set.length; i++) {
                result.retainAll(makeDouble(set[i]));
        }
        return result;
    }
    public static Set<Double> makeDouble(Set<?> set)
    {
        String[] strings = set.toString().replaceAll("[\\[\\],]+", "").split(" ");
        Set<Double> d = new HashSet<>();
        for (String str : strings) {
            d.add(Double.parseDouble(str));
        }
        return d;
    }

}
