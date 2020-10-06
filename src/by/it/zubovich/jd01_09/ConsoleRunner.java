package by.it.zubovich.jd01_09;

import by.it.zubovich.jd01_07.Var;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Parser printer = new Parser();
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")) {
                break;
//                Var result = parser.calc(expression);
//                printer.print(result);
            }
        }
    }
}
