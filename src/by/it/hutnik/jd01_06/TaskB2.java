package by.it.hutnik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String sb = Poem.text;
        sb = sb.replaceAll("\\n", " ").replaceAll("[\\.]{3,}", " ").replaceAll("[\\s]{3,}", " ");
        String[] strArr = sb.split("\\.");
        int[] numb = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder sbNew = new StringBuilder(strArr[i]);
            Pattern pattern = Pattern.compile("\\p{Punct}");
            Matcher matcher = pattern.matcher(sbNew);
            while (matcher.find()) {
                int pos = matcher.start();
                sbNew.setCharAt(pos, ' ');
            }
            strArr[i] = sbNew.toString().replaceAll("[\\s]{2,}", " ");
            strArr[i] = strArr[i].trim();
        }
        for (int i = numb.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strArr[j].length() > strArr[j + 1].length()) {
                    String temp = strArr[j];
                    strArr[j] = strArr[j + 1];
                    strArr[j + 1] = temp;
                }

            }

        }
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
            
        }
        //System.out.println(sb);
//        Pattern pattern = Pattern.compile("\\p{Punct}");
//        Matcher matcher = pattern.matcher(Poem.text);
//        while (matcher.find()) {
//            int start = matcher.start();
//            sb.setCharAt(start, ' ');
//        }
//        int n = 0;
//        int p = 0;
//        int k = 0;
//        for (int i = 0; i <= n; i++) {
//            while (p != -1) {
//                p = sb.indexOf("\n", p);
//                if (p != -1) {
//                    String s1 = sb.substring(k, p);
//                        s1 = s1.trim().replaceAll(" +", " ");
//                        int d = s1.length();
//                        System.out.println(s1 + "=" + d);
//                        k = p;
//                        p++;
//                        n++;
//                        break;
//
//                    }
//                }
//            }
//
//            p = sb.lastIndexOf("\n", sb.length() - 1);
//            String s2 = sb.substring(p, sb.length() - 1);
//            s2 = s2.trim();
//            System.out.print(s2 + "=" + s2.length());
//            System.out.println();
//            System.out.println("ИТОГО ПЕРЕНОСОВ В ТЕКСТЕ=" + n);
//
//
//
//    }
    }
}
