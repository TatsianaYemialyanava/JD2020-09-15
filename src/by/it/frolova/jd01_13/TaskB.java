package by.it.frolova.jd01_13;

/*считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
 переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
ранее введенных чисел, включая введенное;
 если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
сообщение в консоли сообщение, такого же формата, как в предыдущем задании
 если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException*/

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        try {
            for (; ; ) {
                String input = sc.nextLine();
                if (input.equals("END")) {
                    break;
                } else {
                    double result = Double.parseDouble(input);
                    sum += result;
                    if(result < 0) {
                        throw new ArithmeticException();
                    }
                    double root = Math.sqrt(sum);
                    System.out.println(root);
                }
            }
        } catch (NumberFormatException | ArithmeticException e) {
            Class<?> aClass = e.getClass();
            String exceptionName = aClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            printException(exceptionName, stackTrace);
        }
    }

    private static void printException(String exceptionName, StackTraceElement[] stackTrace) {
        for (StackTraceElement element : stackTrace) {
            String methodName = element.getMethodName();
            if (methodName.equals("main")) {
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                System.out.printf("name: %s class: %s line: %d", exceptionName, className, lineNumber);
                break;
            }
        }
    }
}
