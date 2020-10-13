package by.it.moiseyenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[]array1={1,1,2,2,3,4,5,6,6,6};
        Integer[]array2={5,5,5,4,6,7,8,9,9,9,0};
        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> list2 = Arrays.asList(array2);
        Set<Integer> set1= new HashSet<>(list1);
        Set<Integer> set2= new HashSet<>(list2);

        System.out.printf("set1=%s\n",set1);
        System.out.printf("set2=%s\n",set2);
        Set<Integer>union=getUnion(set1,set2);
        System.out.printf("union=%s\n",union);
        Set<Integer>cross=getCross(set1,set2);
        System.out.printf("cross=%s\n",cross);
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
