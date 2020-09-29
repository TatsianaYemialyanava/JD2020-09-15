package by.it.hutnik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start, ' ');
        }
        int n = 0;
        int p = 0;
        int k = 0;
        for (int i = 0; i <= n; i++) {
            while (p != -1) {
                p = sb.indexOf("\n", p);
                if (p != -1) {
                    String s1 = sb.substring(k, p);
                        s1 = s1.trim().replaceAll(" +", " ");
                        int d = s1.length();
                        System.out.println(s1 + "=" + d);
                        k = p;
                        p++;
                        n++;
                        break;

                    }
                }
            }

            p = sb.lastIndexOf("\n", sb.length() - 1);
            String s2 = sb.substring(p, sb.length() - 1);
            s2 = s2.trim();
            System.out.print(s2 + "=" + s2.length());
            System.out.println();
            System.out.println("ИТОГО ПЕРЕНОСОВ В ТЕКСТЕ=" + n);



    }
}
