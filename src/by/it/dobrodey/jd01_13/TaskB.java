package by.it.dobrodey.jd01_13;
/*
TaskB. В классе TaskB напишите цикл, который:
 считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
 переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
ранее введенных чисел, включая введенное;
 если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
сообщение в консоли сообщение, такого же формата, как в предыдущем задании
 если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException
 name: java.lang.NullPointerException
class: by.it.вашпакет.jd01_13.TaskA
 line: 8
 */

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double parseDouble;
        parseDouble = 0;
        double sqrtSum;
        for (; ; ) {
            String unput = sc.next();
            if (unput.equals("END")) {
                break;
            }
            try {
                parseDouble = Double.parseDouble(unput);
                sum += parseDouble;
            } catch (NumberFormatException e) {
                printException(e);
                break;
            }
            try {
                if (sum>0) {
                    sqrtSum = sqrt(sum);
                    System.out.printf("Our number = " + parseDouble + " sqrt(sum) = " + sqrtSum + "\n");
                }
                else throw new ArithmeticException();
            } catch (ArithmeticException e) {
                printException(e);
            }
        }
    }


    private static void printException(Exception e) {
        String s = e.toString().replaceAll("java.lang.","");
        for (StackTraceElement element : e.getStackTrace()) {

            if (element.getMethodName().equals("main")) {
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();

                System.out.printf("  name: %s\n class: %s\n  line: %d \n",
                        s, className, lineNumber);
                break;
            }
        }
    }
}
