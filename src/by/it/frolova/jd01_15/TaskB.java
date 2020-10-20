package by.it.frolova.jd01_15;

import java.io.*;
import java.util.Objects;

public class TaskB {

    public static final String JAVA = ".java";
    public static final String TXT = ".txt";
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private int a = 0; //однострочный комментарий 1
    //однострочный комментарий 2
    /* а роза упала на лапу азора
       ароза упал ан алапу азор а
    */
    /* Аргентина манит негра
       арген тинам анитнегра
    */

    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + JAVA;
        String filenameWrightTo = getPath(TaskB.class) + TXT;
        StringBuilder sb = new StringBuilder();
        readToStringBuilder(filename, sb);
        String text = sb.toString().trim();
        System.out.println(text);
        printToFile(filenameWrightTo, text);
    }

    private static void printToFile(String filenameWrightTo, String text) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filenameWrightTo);
            printWriter.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }

    private static void readToStringBuilder(String filename, StringBuilder sb) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int symbol;
            boolean inOneLineComment = false;
            boolean inMultiLineComment = false;
            while ((symbol = bufferedReader.read()) != -1) {
                char ch = (char) symbol;
                if (ch == '/') {
                    int nextSymbol = bufferedReader.read();
                    if (nextSymbol == -1) {
                        break;
                    }
                    char nextCh = (char) nextSymbol;
                    if (nextCh == '/') {
                        inOneLineComment = true;
                    } else if (nextCh == '*') {
                        inMultiLineComment = true;
                    } else {
                        if (!inOneLineComment && !inMultiLineComment) {
                            sb.append(ch);
                            sb.append(nextCh);
                        }
                    }
                } else if (inOneLineComment && ch == '\n') {
                    inOneLineComment = false;
                    sb.append('\n');
                } else if (inMultiLineComment && ch == '*') {
                    int nextSymbol = bufferedReader.read();
                    if (nextSymbol == -1) {
                        break;
                    }
                    char nextChar = (char) nextSymbol;
                    if (nextChar == '/') {
                        inMultiLineComment = false;
                        //sb.append('\n');
                    }
                } else {
                    if (!inOneLineComment && !inMultiLineComment) {
                        sb.append(ch);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param
     * @throws Exception
     */

    private static String getPath(Class<TaskB> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName + bClass.getSimpleName();
    }
}
