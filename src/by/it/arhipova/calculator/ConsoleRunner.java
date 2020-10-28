package by.it.arhipova.calculator;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for(;;){
            String expression = sc.nextLine();
            if (expression.equals("end")) break;
            Var result = null;
            try {
                result = parser.calc(expression);
            } catch (CalcExeption e) {
                String message = e.getMessage();
                System.out.println(message);
            }
            printer.print(result);
        }

    }
}
