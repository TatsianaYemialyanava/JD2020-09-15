package by.it.lapkovskiy.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        int n=15;
        ArrayList<String> arra = new ArrayList<>(n);
        LinkedList<String> arrl = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arra.add("n" + i);
            arrl.add("n" + i);
        }
        System.out.println(process(arra));
        System.out.println(process(arrl));
    }
    static String process(ArrayList<String> peoples)
    {
        int i =1;
        int curI =0;
        while (true){
            if(curI== peoples.size()) curI=0;
            if(i==2){
                i=1;
                peoples.remove(curI);
            }else{
            i++;
            curI++;
            }
            if(peoples.size()==1) break;
        }
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples)
    {
        int i =1;
        int curI =0;
        while (true){
            if(curI== peoples.size()) curI=0;
            if(i==2){
                i=1;
                peoples.remove(curI);
            }else{
                i++;
                curI++;
            }
            if(peoples.size()==1) break;
        }
        return peoples.get(0);
    }
}
