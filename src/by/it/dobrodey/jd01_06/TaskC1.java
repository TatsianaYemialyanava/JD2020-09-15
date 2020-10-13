package by.it.dobrodey.jd01_06;

public class TaskC1 {
    /**
     * TaskC1. Отформатировать исходный текст с выравниванием по обоим краям. Для этого
     * добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной, а
     * число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
     * причем на единицу большие последовательности пробелов должны идти с начала строки.
     */
    public static void main(String[] args) {
        String text = Poem.text;
        String[] line = text.split("\\n+");
        int maxLengh = Integer.MIN_VALUE;
        for (String s : line) {
            if (maxLengh < s.length()) {
                maxLengh = s.length();
            }
        }
        //System.out.println(maxLengh);
        for (String s : line) {
            newLine(s, maxLengh);
        }

    }
    private static void newLine(String line, int maxLengh) {
        StringBuilder stroka = new StringBuilder(line);

        int position = 0;int count = 0;
        while (stroka.length() < maxLengh) {
            position = stroka.indexOf(" ", position);
            if (position < 0) {
                position = 0;
                count++;
                continue;
            }
            stroka.insert(position, " ");
            position += count + 2;
        }
        System.out.println(stroka);
    }


}

