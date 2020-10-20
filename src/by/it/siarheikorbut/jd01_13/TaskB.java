package by.it.siarheikorbut.jd01_13;

import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double parseDouble;
        double sqrtSum;
        for (; ; ) {
            String input = sc.next();
            if (input.equals("END")) {
                break;
            }
            try {
                parseDouble = Double.parseDouble(input);
                sum += parseDouble;
            } catch (NumberFormatException e) {
                printException(e);
                break;
            }
            try {
                if (sum > 0) {
                    sqrtSum = sqrt(sum);
                    System.out.print("Our number = " + parseDouble + " sqrt(sum) = " + sqrtSum + "\n");
                } else throw new ArithmeticException();
            } catch (ArithmeticException e) {
                printException(e);
            }
        }
    }

    private static void printException(Exception e) {
        String s = e.toString().replaceAll("java.lang.", "");
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