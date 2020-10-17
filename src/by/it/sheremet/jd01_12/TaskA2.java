package by.it.sheremet.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
       Integer [] array1 = {1,3,4,3,8,5,9,7,33};
       Integer [] array2 = {2,1,3,6,5,8,9,33,6,7};
        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> list2 = Arrays.asList(array2);
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new TreeSet<>(list2);
        System.out.println(set1);
        System.out.println(set2);
        Set<Integer> cross = getCross(set1,set2);
        System.out.println("getCross "+cross);
        Set<Integer> union = getUnion(set1,set2);
        System.out.println("getUnion "+union);

    }
    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2){
    TreeSet<Integer> result = new TreeSet<>(set1);
    result.retainAll(set2);
    return result;
    }
    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2){
      TreeSet<Integer> result = new TreeSet<>(set1);
      result.addAll(set2);
      return result;
    }

}
