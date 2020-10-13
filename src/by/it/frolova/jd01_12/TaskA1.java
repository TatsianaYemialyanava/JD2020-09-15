package by.it.frolova.jd01_12;

/*Создайте в классе TaskA1 приватное поле - список оценок учеников (с
помощью ArrayList).
 Заполните его из метода main случайными оценками (1-10).
 Удалите неудовлетворительные оценки (1-3) из списка с помощью
нестатического метода void clearBad(List<Integer> grades) с итератором.
 Выведите на консоль оба варианта списка (до и после удаления).*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private static List<Integer> grades;

    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 10 + rnd.nextInt(15);
        grades = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            grades.add(rnd.nextInt(10) + 1);
        }
        System.out.println(grades);
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(grades);
        System.out.println(grades);

    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer grade = iterator.next();
            if (grade < 4){
                iterator.remove();
            }
        }
    }
}
