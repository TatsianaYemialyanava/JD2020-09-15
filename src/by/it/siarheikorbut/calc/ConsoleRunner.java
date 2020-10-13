package by.it.siarheikorbut.calc;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Dtmq3a65M1AIORy_S6eC7CHwxX6PCQGB/view?usp=sharing">Задание JD01_01 ( A, B, C )</a>
 */

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")) {
            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
