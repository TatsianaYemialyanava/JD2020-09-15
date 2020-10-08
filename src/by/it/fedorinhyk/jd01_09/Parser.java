package by.it.fedorinhyk.jd01_09;

import by.it.akhmelev.jd01_09.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){
        expression.replaceAll("\\s+","");

        String[] parts = expression.split(Patterns.OPERATION, 2);

        Var left= Var.createVar(parts[0]);
        if (parts.length==1) return left;
        Var right= Var.createVar(parts[1]);
        if (right==null || left==null) return null;

        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation = matcherOperation.group();
            switch (operation) {
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
