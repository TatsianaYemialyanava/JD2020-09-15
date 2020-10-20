package by.it.kolesnikov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double sum=0;
        for (;;){
            String input = sc.nextLine();
            if(input.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                sum = number + sum;
                if(sum<0) {
                    throw new ArithmeticException();
                }
                System.out.println(number + " " + sqrt(sum));
            }catch (NumberFormatException | ArithmeticException e) {
                Class <?> aClass = e.getClass();
                String exceptionName = aClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement traceElement : stackTrace) {
                    String methodName = traceElement.getMethodName();
                    if (methodName.equals("main")) {
                        String className = traceElement.getClassName();
                        int lineNumber = traceElement.getLineNumber();
                        System.out.printf(" name: %s\n class: %s\n line:%d\n", exceptionName, className, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
