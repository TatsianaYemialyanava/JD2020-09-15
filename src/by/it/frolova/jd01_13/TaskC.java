package by.it.frolova.jd01_13;

/*Нужно написать в TaskC программу, которая будет вводить вещественные числа с
консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в
обратном порядке.
 Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
 Код по чтению чисел с клавиатуры должен быть в методе static void readData().
 Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
 Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
 После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.*/

import java.util.*;

public class TaskC {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        readData();
    }

    static void readData() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                while (true) {
                    double input = Double.parseDouble(scanner.next());
                    list.add(input);
                }
            } catch (NumberFormatException e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                printValues(list);
            }
        }
    }

    private static void printValues(List<Double> list) {
        for (int j = list.size() - 1; j >= 0; j--) {
            if (j > 0) {
                System.out.print(list.get(j) + " ");
            } else {
                System.out.println(list.get(j));
            }
        }
    }
}
