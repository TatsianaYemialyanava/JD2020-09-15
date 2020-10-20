package by.it.fedorinhyk.jd01_15;

import java.io.*;

public class TaskB {
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "TaskB.txt";
    private static final String FILE_TASK_B_JAVA = "TaskB.java";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
    /*Первый
    многострочный
    комментарий
     */

    /**Второй
     * многострочный
     * комментарий
     * @param args
     */

    //Первый однострочный комментарий
    //Второй однострочный комментарий

    public static void main(String[] args) {
        String fileName = getPath(TaskB.class) + FILE_TASK_B_JAVA;
        String fileNameTxt = getPath(TaskB.class) + RESULT_TASK_B;
        StringBuilder sb = new StringBuilder();
        programmread(fileName, sb);
        print(sb.toString(), fileNameTxt);

    }
    private static void programmread(String fileName, StringBuilder stringBuilder) {
        boolean text=false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {
            String programm = bufferedReader.readLine();
            CommentSeparation(stringBuilder, text, bufferedReader, programm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void CommentSeparation(StringBuilder stringBuilder, boolean text, BufferedReader bufferedReader, String programm)
            throws IOException {
        while (programm != null){
            String trim = programm.trim();
            String profull = programm + "\n";
            if(text){
                profull = "";
                if( trim.endsWith("*/")){
                    text = false;
                }
            }
            else {
                if (trim.startsWith("/"+"/")){
                    profull = profull.substring(0, profull.indexOf("/"+"/")) + "\n" ;
                }
                else if( trim.startsWith("/**")) {
                    profull = profull.substring(0, profull.indexOf("/")) + "\n" ;
                    text = true;
                }
                else if (trim.startsWith("/*")){
                    profull = profull.substring(0, profull.indexOf("/")) + "\n" ;
                    text = true;
                }
            }
            stringBuilder.append(profull);
            programm = bufferedReader.readLine();
        }
    }
    private static void print(String str, String fileNameTxt) {
        try(PrintWriter printWriter = new PrintWriter(fileNameTxt)) {
            printWriter.print(str);
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
    }
}