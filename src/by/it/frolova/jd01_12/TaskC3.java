package by.it.frolova.jd01_12;

/*В консоль вводится строка, состоящая из выражений и символов «(», «)»,
«[», «]», «{», «}».
 Проверьте и выведите в консоль корректность расстановки скобок
(true или false) с помощью коллекций.*/

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String symbols = sc.nextLine();
        Pattern pattern = Pattern.compile("[(){}\\[\\]]");
        Matcher matcher = pattern.matcher(symbols);
        while (matcher.find()) {
            String symbol = matcher.group();
            text.add(symbol);
        }
        System.out.println(brackets(text));
    }

    public static boolean brackets(List<String> brackets) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < brackets.size(); i++) {
            String symbol = brackets.get(i);
            if (symbol.equals("(") || symbol.equals("{") || symbol.equals("["))
                stack.push(symbol);
            else if (symbol.equals("]")) {
                if (stack.empty() || !stack.pop().equals("[")) {
                    return false;
                }
            } else if (symbol.equals("}")) {
                if (stack.empty() || !stack.pop().equals("{")) {
                    return false;
                }
            } else if (symbol.equals(")")) {
                if (stack.empty() || !stack.pop().equals("(")) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}

