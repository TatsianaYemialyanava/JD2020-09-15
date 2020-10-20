package by.it.yemialyanava.jd01_13;
    /* Нужно написать в TaskC программу, которая будет вводить вещественные числа с
        консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в
        обратном порядке.
         Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
         Код по чтению чисел с клавиатуры должен быть в методе static void readData().
         Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
        исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
         Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
         После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.*/

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static Scanner sc;
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }

     public static void readData() throws InterruptedException {
        List<Double> row = new LinkedList<>();
        while (sc.hasNext()) {
            String input = sc.next();
            try {
                Double result = Double.parseDouble(input);
                row.add(result);
            } catch (NullPointerException | NumberFormatException e) {
                count++;
                if (count >= 5){
                    throw new RuntimeException("ERROR: Введено более 5 неправильных элементов");
                }
                Thread.sleep(100);
                System.out.println();
                for (int i = row.size() - 1; i >= 0; i--) {

                    System.out.print(row.get(i) + " ");
                }
            }
        }
    }
}
