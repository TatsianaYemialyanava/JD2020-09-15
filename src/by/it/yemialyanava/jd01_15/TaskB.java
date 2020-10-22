package by.it.yemialyanava.jd01_15;
import java.io.*;

public class TaskB {
    private static final String FILE_TASK_B_JAVA = "TaskB.java";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "TaskB.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
    /**
     * Метод преобразования строки в массив
     * @param - входная строка(с числами)
     * @return возвращаемый массив действительных чисел
     */

    public static void main(String[] args) {
        String fileName = getPath(TaskB.class) + FILE_TASK_B_JAVA;
        //System.out.println(s);
        StringBuilder readedJavaText = new StringBuilder();
        //List<Character> list = new ArrayList<>();
        readJavaText(fileName, readedJavaText);
        /*try(CharArrayReader charArrayReader = new CharArrayReader(fileName)) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        String fileNameTxt = getPath(TaskB.class) + RESULT_TASK_B;
        printToFile(readedJavaText.toString(), fileNameTxt);
    }

    private static void readJavaText(String fileName, StringBuilder stringBuilder) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {
            String line = bufferedReader.readLine();
            boolean insideBlock = false;
            while (line != null){
                String trimmedline = line.trim();
                String lineToOutput = line + "\n";
                if(insideBlock){
                    lineToOutput = "";
                    if( trimmedline.endsWith("*/")){
                        insideBlock = false;
                    }
                } else {
                    if (trimmedline.startsWith("/"+"/")){
                        lineToOutput = lineToOutput.substring(0, lineToOutput.indexOf("/"+"/")) + "\n" ;
                    }else if( trimmedline.startsWith("/*") || trimmedline.startsWith("/**")){
                        lineToOutput = lineToOutput.substring(0, lineToOutput.indexOf("/")) + "\n" ;
                        insideBlock = true;
                    }
                }
                stringBuilder.append(lineToOutput);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void printToFile(String str, String fileNameTxt) {
        try(PrintWriter printWriter = new PrintWriter(fileNameTxt)) {
            printWriter.print(str);
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
    }
}
