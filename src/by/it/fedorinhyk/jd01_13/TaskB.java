package by.it.fedorinhyk.jd01_13;

import java.util.HashMap;
import java.util.Scanner;
import static java.lang.StrictMath.sqrt;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double lineparse;
        double sumprev=0;
        for (; ; ) {
            String line = sc.nextLine();
            if (line.equals("END")) break;
            try {
                lineparse = Double.parseDouble(line);
                sumprev += lineparse;
            } catch (NumberFormatException exception) {
                PRINT(exception);
                break; }
            try { if (sumprev > 0) {
                    double sqrtSum = sqrt(sumprev);
                    System.out.println("Число: "+lineparse+" Корень из суммы: "+sqrtSum);
                }
                else throw new ArithmeticException();
            } catch (ArithmeticException exception) {
                PRINT(exception);
            }
        }
    }
    static void PRINT(Exception exception) {
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement element :stackTrace){
            if (TaskB.class.getName().equals(element.getClassName())){
                System.out.println(element);
                String name= exception.getClass().getName();
                String classname= element.getClassName();
                int lineNumber = element.getLineNumber();
                System.out.printf("  name: %s\n class: %s\n  line: %d\n", name,classname,lineNumber);
                break;
            }
        }
    }
}
