package by.it.dobrodey.jd01_06;

import java.util.Arrays;

public class TaskC2 {

    /**
     * TaskC2. Сформировать и вернуть в методе String slow (String text) из случайных слов исходного текста
     * строку String минимум в сто тысяч символов путем конкатенации. Слова должны быть «склеены» через один пробел.
     * Затем: • В методе main: определить время работы метода slow (удобно использовать System.nanoTime()
     * или аналог); вывести полученный текст и время работы метода slow в милисекундах на консоль.
     * Ускорить процесс с StringBuilder (сделать новый метод String fast (String text),
     * ВАЖНО: его итог должен быть таким как в slow до буквы). В main повторить  вывод.
     */

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String text = slow(Poem.text);
        long endTime = System.nanoTime();
        long timeWork = endTime - startTime;      // time(nanosec)
        double timeWorkMs = (double) timeWork / 1000;
        System.out.println(text);
        System.out.println("Time for fast metod = "+timeWorkMs + " msec");
        long startTime1 = System.nanoTime();
        text = fast(text);
        long endTime1 = System.nanoTime();
        System.out.println(text);
        timeWorkMs = (double) (endTime1 - startTime1) / 1000;
        System.out.println("Time for fast metod = "+timeWorkMs + " msec");
    }


    private static String slow(String text) {
        String newText = "";
        text = text.replaceAll("[^а-яА-ЯёЁ]+", " ");
        text = text.trim();
//        text = text.replaceAll("\\s+", " ");

        while (newText.length() <= 100000) newText = newText + text;

//                Arrays.toString(text.split(" "));
//
//
//        newText = newText.replaceAll(", ", " ");
//        newText = newText.replaceAll("\\[(\\s+)?", "");
//        newText = newText.replaceAll("(\\s+)?]", "");
        return newText;
    }

    private static String fast(String text) {
        StringBuilder newText = new StringBuilder(text);


        return newText.toString();
    }


}

