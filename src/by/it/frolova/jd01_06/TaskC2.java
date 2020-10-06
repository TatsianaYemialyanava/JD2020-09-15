package by.it.frolova.jd01_06;

import java.util.Random;

/* Сформировать и вернуть в методе String slow (String text) из случайных слов
исходного текста строку String минимум в сто тысяч символов путем конкатенации. Слова
должны быть «склеены» через один пробел. Затем:
• В методе main: определить время работы метода slow (удобно использовать
System.nanoTime() или аналог); вывести полученный текст и время работы метода slow в
милисекундах на консоль.
• Ускорить процесс с StringBuilder (сделать новый метод String fast (String text),
ВАЖНО: его итог должен быть таким как в slow до буквы). В main повторить вывод.
*/
public class TaskC2 {
    public static void main(String[] args) {
        TaskC2 taskC2 = new TaskC2();
        long startTimeSlow = System.nanoTime();
        System.out.println(taskC2.slow(Poem.text));
        long endTimeSlow = System.nanoTime();
        long startTimeFast = System.nanoTime();
        System.out.println(taskC2.fast(Poem.text));
        long endTimeFast = System.nanoTime();

        System.out.printf("%s %d\n", "the duration of slow method is:", endTimeSlow - startTimeSlow);
        System.out.printf("%s %d\n", "the duration of fast method is:", endTimeFast - startTimeFast);

    }

    private static final long START = System.nanoTime();

    static String slow(String text) {

        String[] words = text.split("[^а-яёА-ЯЁ]+");
        String result = "";
        Random rnd = new Random(START);
        while (result.length() < 100000) {
            int i = rnd.nextInt(words.length);
            result = result.concat(words[i]).concat(" ");
        }
        return result;
    }

    static String fast(String text) {

        String[] words = text.split("[^а-яёА-ЯЁ]+");
        StringBuilder result = new StringBuilder();
        Random rnd = new Random(START);
        while (result.length() < 100000) {
            int i = rnd.nextInt(words.length);
            result = result.append(words[i]).append(" ");
        }

        return result.toString();
    }
}
