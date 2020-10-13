package by.it.yemialyanava.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[-+,;\\.!\\?\\s]");
        Map<String, Integer> slova = new HashMap<>();

        while(sc.hasNext()) {
            String novoeSlovo = sc.next();
            novoeSlovo= normalize(novoeSlovo);
            if (novoeSlovo.equals("end")){
                break;
            } else if (slova.get(novoeSlovo) == null){
                slova.put(novoeSlovo, 1);
            } else {
                Integer count = slova.get(novoeSlovo) + 1;
                slova.put(novoeSlovo, count);
            }
        }

        Set<Map.Entry<String, Integer>> entries = slova.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            System.out.printf("%s=%d\n", entry.getKey(), entry.getValue());
        }
    }

    private static String normalize(String novoeSlovo) {
        if (novoeSlovo.equals("isn't")){
            novoeSlovo = "don't";
        }
        return novoeSlovo;
    }
}
