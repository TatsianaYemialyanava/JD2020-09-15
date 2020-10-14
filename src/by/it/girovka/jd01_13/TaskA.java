package by.it.girovka.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }catch(NumberFormatException e) {
            System.out.println(e);
        }
            catch(NullPointerException e){
                System.out.println(e);
        }
    }
}
