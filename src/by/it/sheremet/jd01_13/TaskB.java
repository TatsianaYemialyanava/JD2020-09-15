package by.it.sheremet.jd01_13;

          //В классе TaskB напишите цикл, который:
        // считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
        // переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
        // ранее введенных чисел, включая введенное;
        // если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
        // сообщение в консоли сообщение, такого же формата, как в предыдущем задании
        // если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        try {
        for (; ; ) {
            String n = sc.next();
            if (n.equals("END")) {
                break;
            }

            double i =Double.parseDouble(n);
            System.out.println(i);
            res = i + res;
            if (i < 0) {
                throw new ArithmeticException();
            }
            double res1 = Math.sqrt(res);
            System.out.println(res1);


        }
    }
            catch (NumberFormatException | ArithmeticException e) {
            Class<?> aClass = e.getClass();
            String exceptionName = aClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
                 for (StackTraceElement traceElement : stackTrace) {
                    String methodName = traceElement.getMethodName();
                         if (methodName.equals("main")) {
                         String className = traceElement.getClassName();
                         int lineNumber = traceElement.getLineNumber();
                         System.out.printf("  name: %s\n class: %s\n  line:%d\n",
                            exceptionName, className, lineNumber);
                         break;
                    }
                 }
            }
    }
}