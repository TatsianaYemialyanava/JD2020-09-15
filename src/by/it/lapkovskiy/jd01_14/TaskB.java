package by.it.lapkovskiy.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TaskB {
    private static final String FILE_DATA = "text.txt";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "resultTaskB.txt";

    public static void main(String[] args)  {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            getFileData(stringBuilder);
            String s="words=" + getWords(stringBuilder.toString())+", marks=" + getT(stringBuilder.toString());
            System.out.println(s);
            setFileData(s);

        } catch (Exception e) {

        }
    }
    private static void setFileData(String line){
        try{
        FileOutputStream fileOutputStream = new FileOutputStream(getPath(TaskB.class)+RESULT_TASK_B);
        fileOutputStream.write(line.getBytes());
        fileOutputStream.close();
        }
        catch (Exception e){

        }
    }

    private static void getFileData(StringBuilder stringBuilder) {
        try {
            FileInputStream fileInputStream = new FileInputStream(getPath(TaskB.class) + FILE_DATA);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF8"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str + " ");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static int getT(String line) {
        String[] ss = line.toString().split("[^-.,!:]+");
        return ss.length - 1;
    }

    private static int getWords(String line) {
        String[] ss = line.toString().split("[^а-яА-ЯёЁ]+");
        return ss.length;
    }

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
}
