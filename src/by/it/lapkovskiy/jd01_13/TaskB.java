package by.it.lapkovskiy.jd01_13;

import java.util.*;

public class TaskB {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int pred=0;
        while (true){
            String input = sc.next();//.replaceAll("[a-zA-Z']+","");
            if (input.equals("END")) {
                break;
            }
            try {
                arrayList.add(Double.parseDouble(input));
                double sum = 0;
                for (Double d : arrayList) {
                    sum += d;
                }
                sum = Math.sqrt(sum);
                if(Double.isNaN(sum)) throw new ArithmeticException("ArithmeticException");
                System.out.printf(Locale.ENGLISH, "%f\n", sum);
            }
            catch (NumberFormatException | NullPointerException | ArithmeticException e)
            {
                Class<? extends RuntimeException> aClass = e.getClass();
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

}

