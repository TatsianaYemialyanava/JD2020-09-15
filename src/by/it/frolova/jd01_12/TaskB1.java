package by.it.frolova.jd01_12;

/*TaskB1. Нужно ввести с консоли текст на английском языке до строки “end” (100 и
более слов).
 Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
 Вывести все различные слова формате слово=частота. Слова, отличающиеся
регистром букв, считать различными. isn't или don’t – одно слово.*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> text = new HashMap<>();
        while (sc.hasNext()) {
            String input = sc.next();
            Pattern pattern = Pattern.compile("[a-zA-Z']+");
            Matcher matcher = pattern.matcher(input);
            if (input.equals("end")) {
                break;
            } else {
                while (matcher.find()) {
                    String word = matcher.group();
                    if (text.containsKey(word)) {
                        text.put(word, text.get(word) + 1);
                    } else {
                        text.put(word, 1);
                    }
                }
            }
        }
        System.out.println(text);
    }
}
