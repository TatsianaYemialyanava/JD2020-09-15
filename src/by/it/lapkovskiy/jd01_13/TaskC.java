package by.it.lapkovskiy.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TaskC {
    public static Stack<Double> doubleStack = new Stack<>();
    public static Stack<Double> doubles = new Stack<>();
    static int ers = 0;
    static Scanner sc1;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sc1 = sc;
        while (true)
        try {
            readData();
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    static void readData() throws Exception {
        try {
            doubleStack.push(Double.parseDouble(sc1.next()));
        } catch (Exception e) {
            Thread.sleep(100);
            ers++;
            if (ers > 5) throw new Exception("More 5 Errors");
            int size = doubleStack.size();
            for (int i = 0; i < size; i++) {
                doubles.add(doubleStack.peek());
                System.out.print(doubleStack.pop() + " ");
            }
            System.out.println();
            size = doubles.size();
            for (int i = 0; i < size; i++) {
                doubleStack.push(doubles.pop());
            }
            doubles.clear();
        }
    }
}
