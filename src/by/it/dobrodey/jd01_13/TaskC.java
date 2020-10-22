package by.it.dobrodey.jd01_13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 TaskC. Нужно написать в TaskC программу, которая будет вводить вещественные числа с консоли, после каждой ошибки
 программа делает паузу в 100 мс и выводит накопленные числа в обратном порядке.
  Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
  Код по чтению чисел с клавиатуры должен быть в методе static void readData().
  Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить исключение,
  сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
   Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
   После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.
 */
public class TaskC {
    static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        scanner =sc;
        readData();
    }

    static void readData() throws InterruptedException {
        int counter = 0;
        Deque<Double> doubles = new ArrayDeque<>();
        for (; ; ) {
            String string = scanner.next();
            try {
                double v = Double.parseDouble(string);
                doubles.addFirst(v);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                for (Double aDouble : doubles) {
                    System.out.print(aDouble + " ");
                }
                System.out.println();
                if (counter < 4) {
                    counter += 1;
                } else throw new NumberFormatException();
            }
        }
    }
}
