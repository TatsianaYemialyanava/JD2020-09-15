package by.it.fedorinhyk.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int pozzero=0;
        for (;;) {
            String input= sc.next();
            if (input.equals("end")){
                break;
            }
            Integer i= Integer.valueOf(input);
            if (i==0){
                list.add(pozzero,i);
            }
            else if (i<0){
                list.add(i);
            }
            else{ list.add(pozzero++,i);
            }
        }
        System.out.println(list);
    }
}
