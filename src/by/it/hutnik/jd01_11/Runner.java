package by.it.hutnik.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

    }
}

//public class Runner {
//    public static void main(String[] args) {
//    Set<String> objects = new SetC<>();
//        objects.add("1");
//                objects.add("2");
//                objects.add("3");
//                objects.add("4");
//                objects.add("5");
//                objects.add("6");
//                objects.add("6");
//                objects.add("3");
//                System.out.println(objects);
//                Set<String> objects1 = new SetC<>();
//        objects1.add("1");
//        objects1.add("2");
//        objects1.add("3");
//        objects1.add("4");
//        System.out.println("ob1="+objects1);

//    Set<String> ob = new HashSet<>();
//        ob.add("1");
//                ob.add("2");
//                ob.add("3");
//                ob.add("4");
//                ob.add("5");
//                ob.add("6");
//                ob.add("6");
//                ob.add("3");
//                System.out.println("ob = "+ob);
//
//                Set<String> ob1 = new HashSet<>();
//        ob1.add("1");
//        ob1.add("2");
//        ob1.add("3");
//        ob.addAll(ob1);
//        System.out.println("ob1="+ob1);
//        objects.clear();
//        System.out.println("objects.removeAll(ob1)="+objects);
//        System.out.println("objects= "+objects);
