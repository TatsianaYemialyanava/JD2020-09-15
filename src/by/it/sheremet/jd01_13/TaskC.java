package by.it.sheremet.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner (System.in);
        readData();
    }

    static void readData() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                while (true) {
                    double input = Double.parseDouble(scanner.next());
                    list.add(input);
                }
                }catch(NumberFormatException e){

            } try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printDouble(list);
        }
    }
    private static void printDouble(List<Double> list) {

    }
}
