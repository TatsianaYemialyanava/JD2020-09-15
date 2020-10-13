package by.it.dobrodey.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

/*
TaskA3. В main класса TaskA3 вводите список чисел с клавиатуры до ввода
слова “end”.
 Переставьте отрицательные элементы списка чисел в конец, а положительные —
в начало списка, сохраняя их порядок относительно друг друга.
 Выведите список на консоль методом коллекции toString().
 */
public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> number = new ArrayList<>();
        int pozZero = 0;
        for(;;){
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }
            Integer i = Integer.valueOf(input);
            if (i==0){ number.add(pozZero,i);}
            else if (i<0){number.add(i);}
            else {number.add(pozZero++,i);}

    }
        System.out.println(number);
}
}


