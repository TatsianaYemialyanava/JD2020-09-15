package by.it.dobrodey.calc;


import by.it.akhmelev.calculator.CalcException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        //2=2 -> scalar==4
        if (expression.isEmpty()) {
            throw new CalcException("You don't enter anything");
        }

        expression.replaceAll("\\s+", "");

        String[] parts = expression.split(by.it.akhmelev.calculator.Patterns.OPERATION, 2);
        if (parts.length==1) return Var.createVar(parts[0]);

        Var right= Var.createVar(parts[1]);
        if (expression.contains("=")) {
            return Var.save(parts[0],right);
        }

        Var left= Var.createVar(parts[0]);
        if (right == null || left == null) throw new CalcException("?");

        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }
        return null;
    }
}