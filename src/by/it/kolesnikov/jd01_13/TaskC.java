package by.it.kolesnikov.jd01_13;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TaskC. Нужно написать в TaskC программу, которая будет вводить вещественные числа с
//консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в
//обратном порядке.
// Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
// Код по чтению чисел с клавиатуры должен быть в методе static void readData().
// Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
//исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
// Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
// После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.

public class TaskC {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new LinkedList<>();
            readData(sc, list);
    }

    static void readData(Scanner sc, List<Double> list) throws InterruptedException {
            try {
                for (; ; ) {
                    Double input = sc.nextDouble();
                    list.add(input);
                }
    } catch (InputMismatchException e) {
           Thread.sleep(100);
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.print(list.get(j) + " ");
            }
            }
    }
}
