package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12 ( 2 )</a>
 */

public class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 5, 6, 6));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(9, 8, 7, 4, 4, 4, 5, 5, 6, 6));
        System.out.println(getUnion(treeSet, hashSet));
        System.out.println(getCross(treeSet, hashSet));
    }
}