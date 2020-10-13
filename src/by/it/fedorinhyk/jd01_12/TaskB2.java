package by.it.fedorinhyk.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        ArrayList<String> array = new ArrayList<>(N);
        LinkedList<String> linked = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            array.add(String.valueOf(N + i));
            linked.add(String.valueOf(N + i));
        }
        System.out.println(process(array));
        System.out.println(process(linked));
    }
    public static String process(ArrayList<String> peoples){
        int last =1;
        int sub =0;
        do {
            if (sub == peoples.size()) sub = 0;
            if (last == 2){
                last = last/2;
                peoples.remove(sub);
            }
            else {
                last=last+1;
                sub=sub+1;
            }
        } while (peoples.size() > 1);
        return peoples.get(0);
    }
    public static String process(LinkedList<String> peoples){
        int last =1;
        int sub =0;
        do {
            if (sub == peoples.size()) sub = 0;
            if (last == 2){
                last = last/2;
                peoples.remove(sub);
            }
            else {
                last=last+1;
                sub=sub+1;
            }
        } while (peoples.size() > 1);
        return peoples.get(0);
    }
}