package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12 ( A1 )</a>
 */

public class TaskA1 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 10 + (int) (Math.random() * 15);
        List<Integer> grades = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            grades.add(rnd.nextInt(10) + 1);
        }
        System.out.println(grades);
        TaskA1 instance = new TaskA1();
        instance.clearBad(grades);
        System.out.println(grades);
    }

    private void clearBad(List<Integer> gr2) {
        gr2.removeIf(grade -> grade < 4);
    }
}
