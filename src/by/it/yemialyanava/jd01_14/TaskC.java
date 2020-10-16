package by.it.yemialyanava.jd01_14;
/*В классе TaskC нужно выполнить следующие шаги:
         Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
        формате file:имя_файла или dir:имя_каталога.
         Продублировать вывод в консоль в файл resultTaskC.txt*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class TaskC {

    private static final String TEXT_DATA = "text.txt";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_C = "resultTaskС.txt";

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
    public static void main(String[] args) {
        String pathToDir14 = getPath(TaskC.class);
        File file14 = new File(pathToDir14);
        StringBuilder output = new StringBuilder();
        if (file14.isDirectory()){
            File packageName = file14.getParentFile();
            File [] arrayFiles = packageName.listFiles();
            for (File element: arrayFiles) {
                if(element.isFile()){
                    output.append("file:" + element.getName()).append("\n");
                    System.out.println("file:" + element.getName());
                }else if (element.isDirectory()){
                    output.append("dir:" + element.getName()).append("\n");
                    System.out.println("dir:" + element.getName());
                    File packageName = file14.getParentFile();
                    File [] arrayFiles = packageName.listFiles();

                }
            }
        }
        String fileNameTxt = getPath(TaskC.class) + RESULT_TASK_C;
        printToFile(output.toString(), fileNameTxt);


    }
    private static void printToFile(String strToFile, String fileNameTxt) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileNameTxt);
            printWriter.println(strToFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(printWriter)) {
                printWriter.close();
            }
        }
    }

}
