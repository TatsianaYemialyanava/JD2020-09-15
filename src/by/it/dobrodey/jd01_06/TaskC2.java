package by.it.dobrodey.jd01_06;

import java.util.Random;

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
        System.out.println("Time for fast metod = " + timeWorkMs + " msec");
        long startTime1 = System.nanoTime();
        text = fast(Poem.text);
        long endTime1 = System.nanoTime();
        System.out.println(text);
        timeWorkMs = (double) (endTime1 - startTime1) / 1000;
        System.out.println("Time for fast metod = " + timeWorkMs + " msec");
    }


    static String slow(String text){

        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String out = "";
        Random random = new Random(7);
        while (out.length() < 100000) {
            out = out.concat(words[random.nextInt(words.length)]).concat(" ");
            }
        return out;
        }
    static String fast(String text){
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder out = new StringBuilder("");
        Random random = new Random(7);
        while (out.length()<100000){
            out=out.append(words[random.nextInt(words.length)]).append(" ");
        }
        return out.toString();
        }
    }

