package by.it.frolova.jd01_11;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
//        String[] str = {"сорок", "пятьдесят"};
//        List<String> stringList = new ArrayList<>();
//        stringList.add("one");
//        stringList.add("two");
//        stringList.add("three");
//        System.out.println(stringList);
//
//        List<String> listA = new ListA<>();
//        listA.add("four");
//        listA.add("five");
//        listA.add("six");
//        System.out.println(listA);
//
//        stringList.remove(1);
//        System.out.println(stringList);
//        listA.remove(1);
//        System.out.println(listA + "\n" + "---------------------------------------------");
//
//        stringList.add(1, "two");
//        System.out.println(stringList);
//        stringList.addAll(listA);
//        System.out.println(stringList);
//
//        stringList.add(2, "addedIntoIndex");
//        System.out.println(stringList);
//
//        List<String> listB = new ListB<>();
//        listB.add("aaa");
//        listB.add("bbb");
//        listB.add("ccc");
//        listB.add(1, "zzz");
//        System.out.println(listB);
//        System.out.println(stringList);
//        listB.addAll(stringList);
//        System.out.println("listB before set: " + listB);
//        stringList.set(3,"set");
//        System.out.println(stringList);
//        listB.set(3,"set");
//        System.out.println("listB after set: " + listB);
//        listB.remove(5);
//        System.out.println("listB after remove \"two\" : " + listB);

        Set<String> hashSet = new HashSet<>();
        hashSet.add("bear");
        hashSet.add("fox");
        hashSet.add("deer");
        hashSet.add("fox");
        System.out.println(hashSet);
        
        Set<String> set = new SetC<>();
        set.add("bear");
        set.add("fox");
        set.add("deer");
        set.add("fox");
        System.out.println(set);

    }
}
