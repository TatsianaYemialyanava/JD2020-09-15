package by.it.lapkovskiy.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB3 {
    static String process(ArrayList<String> peoples)
    {
        while (true){
            peoples.add(peoples.get(0));
            peoples.remove(0);
            peoples.remove(0);
            if(peoples.size()==1) break;
        }
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples)
    {
        while (true){
            peoples.addLast(peoples.get(0));
            peoples.remove(0);
            peoples.remove(0);
            if(peoples.size()==1) break;
        }
        return peoples.get(0);
    }
}
