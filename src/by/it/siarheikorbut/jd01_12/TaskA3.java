package by.it.siarheikorbut.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12 ( A3 )</a>
 */

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        int pos = 0;
        while (!(str = sc.next()).equals("end")) {
            int value = Integer.parseInt(str);
            if (value > 0)
                arr.add(pos++, value);
            else if (value == 0) {
                arr.add(pos, 0);
            } else {
                arr.add(value);
            }
            System.out.println(arr);
        }
    }
}