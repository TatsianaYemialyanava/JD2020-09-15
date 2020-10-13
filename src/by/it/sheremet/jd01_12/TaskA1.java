package by.it.sheremet.jd01_12;

        //Создайте в классе TaskA1 приватное поле - список оценок учеников (с
        //помощью ArrayList).
        //Заполните его из метода main случайными оценками (1-10).
        //Удалите неудовлетворительные оценки (1-3) из списка с помощью
        //нестатического метода void clearBad(List<Integer> grades) с итератором.
        //Выведите на консоль оба варианта списка (до и после удаления).

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private static List<Integer> grades;

    public static void main(String[] args) {
        Random rnm = new Random();
        int n = 10+rnm.nextInt(21);
        grades = new ArrayList<>(n);
        for (int i = 0; i < n ; i++) {
            grades.add(rnm.nextInt(11));
        }
        System.out.println(grades);
        TaskA1 instance = new TaskA1();
        instance.clearBad(grades);
        System.out.println(grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if(grade<4){
                iterator.remove();
            }
        }
    }

}
