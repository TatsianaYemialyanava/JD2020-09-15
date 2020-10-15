package by.it.lapkovskiy.calculator;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        //2*2 -> scalar==4
        expression.replaceAll("\\s+", "");

        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) return Var.createVar(parts[0]);

        Var right = Var.createVar(parts[1]);
        if (expression.contains("=")) {
            return Var.save(parts[0], right);
        }

        Var left = Var.createVar(parts[0]);
        if (right == null || left == null) return null;

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

    boolean CheckBracket(String line) throws CalcException {
        Stack<Character> stack = new Stack<>();
        char[] brackets = line.toCharArray();
        int i = 0;

        if(!line.equals(line.replace("[\\{\\}\\[\\]\\(\\)]+","")))
        while (true) {
            if (brackets[i] == '{' || brackets[i] == '(' || brackets[i] == '[') stack.push(brackets[i]);
            else {
                if (stack.isEmpty()) {
                    System.out.println("Bracket Error excess:"+(Character)brackets[i]+" in "+i);
                    return false;
                }
                if (brackets[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (brackets[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (brackets[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    System.out.println("Bracket Error excess:"+(Character)brackets[i]+" in "+i);
                    return false;
                }
            }
            i++;
            if (i == brackets.length) {
                if(stack.isEmpty()) return true;
                else{
                    System.out.println("Bracket Error excess:"+stack.pop());
                    return false;
                }
            }
        }
        else return true;
    }
}
