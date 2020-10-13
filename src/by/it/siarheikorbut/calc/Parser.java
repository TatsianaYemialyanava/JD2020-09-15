package by.it.siarheikorbut.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Dtmq3a65M1AIORy_S6eC7CHwxX6PCQGB/view?usp=sharing">Задание JD01_01 ( A, B, C )</a>
 */

public class Parser {

    //Вычисление вычесленной готовой переменной.
    Var calc(String expression) {
        String[] operand = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")){
            return Var.saveVar(operand[0],two);
        }
        Var one = Var.createVar(operand[0]);
        if (one == null || two == null)
            return null; //TODO create error
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }
}
