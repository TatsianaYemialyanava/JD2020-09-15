package by.it.kolesnikov.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer>set1=new HashSet<>(Arrays.asList(1,1,2,2,3,4,5,6,6,6,100));
        Set<Integer>set2=new TreeSet<>(Arrays.asList(5,5,5,4,6,7,8,9,9,9,10));
        System.out.println(getCross(set1,set2));
        System.out.println(getUnion(set1,set2));

    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        set1.addAll(set2);
        return set1;
    }
}
