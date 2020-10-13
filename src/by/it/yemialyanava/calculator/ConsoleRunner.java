package by.it.yemialyanava.calculator;

import java.util.Map;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for (;;){
            String expression = scan.nextLine();
            if (expression.equals("end")){
                break;
            }
           /* if (expression.equals("printvar")) {
                for (Map.Entry<String, String> entry : getVarMap(varMap).entrySet()){
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }*/
            //}
            Var result = parser.calc(expression);
            printer.print(result);
        }
    }
}
