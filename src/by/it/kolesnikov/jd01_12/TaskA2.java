package by.it.kolesnikov.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer>set1=new HashSet<>(Arrays.asList(1,2,3,4,5,6,2,2,1));
        Set<Integer>set2 = new TreeSet<>(Arrays.asList(9,7,8,5,6,4,4,6,6));
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(getCross(set1,set2));
        System.out.println(getUnion(set1,set2));
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}
