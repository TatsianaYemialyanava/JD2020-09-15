package by.it.fedorinhyk.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    public static void main(String[] args) {
        Random ram= new Random();
        int size=10+ ram.nextInt(15);
        List<Integer> grades = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            grades.add(ram.nextInt(10)+1);
        }
        System.out.println(grades);
        TaskA1 instance= new TaskA1();
        instance.clearBad(grades);
        System.out.println(grades);
    }

    private void clearBad(List<Integer> grades2) {
        grades2.removeIf(grade -> grade < 4);
    }
}
