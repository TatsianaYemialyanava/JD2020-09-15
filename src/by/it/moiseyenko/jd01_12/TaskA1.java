package by.it.moiseyenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private static List<Integer> grades;

    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 10 + rnd.nextInt(15); //size
        grades = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grades.add(rnd.nextInt(10) + 1);
        }
        System.out.println(grades);
        TaskA1 instance = new TaskA1();
        instance.clearBad(grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer grade = iterator.next();
                if(grade<4){
                    iterator.remove();
                }
        }
    }
}