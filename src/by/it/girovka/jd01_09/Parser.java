package by.it.girovka.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression){

        String[] parts = expression.split(Patterns.OPERATION,2);

        Var left = Var.createVar(parts[0]);
        if (parts.length==1) return left;
        Var right = Var.createVar(parts[1]);
        if (right == null || left == null)
            return null;
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m =p.matcher(expression);
        if(m.find()){
            String operation = m.group();
            switch(operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
