package by.it.dobrodey.jd01_11;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
//
//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");
//
//        List<String> list2 = new ListB<>();
//        list2.add("olga");
//        list2.add("volga");
//        System.out.println("list2= " + list2);
//        System.out.println("list=" + list);
//        list2.addAll(list);
//        System.out.println("C=" + list2);

        Set<String> objects = new SetC<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("5");
        objects.add("6");
        objects.add("6");
        objects.add("3");
       System.out.println(objects);
        Set<String> objects1 = new SetC<>();
        objects1.add("1");
        objects1.add("2");
        objects1.add("3");
        objects1.add("4");
        System.out.println("ob1="+objects1);
//        System.out.println(ob.isEmpty());
//        System.out.println(ob.size());
//        System.out.println(ob.contains("8"));



//        objects.remove("4");
//        System.out.println(objects);
//        System.out.println(objects.isEmpty());
//        System.out.println(objects.size());
//        System.out.println(objects.contains("8"));

        Set<String> ob = new HashSet<>();
        ob.add("1");
        ob.add("2");
        ob.add("3");
        ob.add("4");
        ob.add("5");
        ob.add("6");
        ob.add("6");
        ob.add("3");
        System.out.println("ob = "+ob);

        Set<String> ob1 = new HashSet<>();
        ob1.add("1");
        ob1.add("2");
        ob1.add("3");
        ob.addAll(ob1);
       System.out.println("ob1="+ob1);
        objects.clear();
        System.out.println("objects.removeAll(ob1)="+objects);
        System.out.println("objects= "+objects);
//        System.out.println(ob.isEmpty());
//        System.out.println(ob.size());
//        System.out.println(ob.contains("8"));


//    System.out.println("ob.removeAll(ob1)="+ob.removeAll(ob1));
//    System.out.println("ob= "+ob);

    }
}
