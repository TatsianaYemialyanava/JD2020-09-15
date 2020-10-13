package by.it.frolova.jd01_12;

/*В main класса TaskA3 вводите список чисел с клавиатуры до ввода
слова “end”.
 Переставьте отрицательные элементы списка чисел в конец, а положительные —
в начало списка, сохраняя их порядок относительно друг друга.
 Выведите список на консоль методом коллекции toString().*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int position = 0;
        for (; ; ) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }
            Integer i = Integer.valueOf(input);
            if (i == 0) {
                list.add(position, i);
            } else if (i < 0) {
                list.add(i);
            } else if (i > 0) {
                list.add(position++, i);
            }
        }
        System.out.println(list.toString());
    }
}
