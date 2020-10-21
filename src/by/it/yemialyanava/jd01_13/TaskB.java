package by.it.yemialyanava.jd01_13;
        /*В классе TaskB напишите цикл, который:
          считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
          переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
         ранее введенных чисел, включая введенное;
          если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
         сообщение в консоли сообщение, такого же формата, как в предыдущем задании
          если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException*/

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int summa = 0;
        try {
            while (sc.hasNext()) {
                String input = sc.nextLine();
                if (input.equals("END")) {
                    break;
                } else {
                    double tekushee = Double.parseDouble(input);
                    summa += tekushee;
                    if (tekushee < 0) {
                        throw new ArithmeticException();
                    }
                    double root = Math.sqrt(summa);
                    System.out.println(tekushee + " " + root);
                }
            }
        } catch (NumberFormatException |NullPointerException| ArithmeticException e) {
            Class<? extends RuntimeException> aClass = e.getClass();
            String exceptionName = aClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            printException(exceptionName, stackTrace);
        }
    }

    private static void printException(String exceptionName, StackTraceElement[] stackTrace) {
        for (StackTraceElement traceElement : stackTrace) {
            String methodname = traceElement.getMethodName();
            if (methodname.equals("main")) {
                String className = traceElement.getClassName();
                int lineNumber = traceElement.getLineNumber();
                System.out.printf("name: %s\n class: %s\n line: %s\n", exceptionName, className, lineNumber);
                break;
            }
        }
    }
}
