package by.it.lapkovskiy.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner scanner = new Scanner(System.in);
        String scob = scanner.nextLine();
        char[] scobs = scob.toCharArray();
        int i = 0;
        while (true) {
            if (scobs[i] == '{' || scobs[i] == '(' || scobs[i] == '[') stack.push(scobs[i]);
            else {
                if (stack.isEmpty()) {
                    System.out.println(false);
                    break;
                }
                if (scobs[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (scobs[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (scobs[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    System.out.println(false);
                    break;
                }
            }
            i++;
            if (i == scobs.length) {
                System.out.println(stack.isEmpty());
                break;
            }
        }
    }

}
