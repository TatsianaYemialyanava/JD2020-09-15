package by.it.sheremet.jd01_12;

import by.it.sheremet.jd01_02.TaskB;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
            ArrayList<String> names1 = new ArrayList<String>();
            LinkedList<String> names2 = new LinkedList<String>();
            String[] arr = {"Vlad", "Sam", "Bill", "Alex", "Rose", "Liza", "Dan", "Bob", "Karolina","Alla"};
            for (String s : arr) {
                names1.add(s);
                names2.add(s);
            }
            String name1 = process(names1);
            System.out.println(name1);
            String name2 = process(names2);
            System.out.println(name2);
        }

        static String process(ArrayList<String> peoples) {
            int n = 0;
            Iterator<String> iterator = peoples.iterator();
            while (peoples.size() != 1) {
                while (iterator.hasNext()){
                    iterator.next();
                        if(n==1){
                        iterator.remove();
                        n = 0;
                        continue;
                    }
                    n=1;
                }
                iterator = peoples.iterator();
            }
            String result = peoples.toString();
            result = result.replaceAll("\\[", "");
            result = result.replaceAll("\\]", "");
            return result;
        }


        static String process(LinkedList<String> peoples) {
            int n = 1;
            while (!(peoples.size() == 1)) {
                int length = peoples.size();
                for (int i = n; i < peoples.size(); i++) {
                    peoples.remove(i);
                }
                if (!(length % 2 == 0)) {
                    if (n == 1) {
                        n = 0;
                    } else n = 1;
                }
            }
            String result = peoples.toString();
            result = result.replaceAll("\\[", "");
            result = result.replaceAll("\\]", "");
            return result;
        }

}
