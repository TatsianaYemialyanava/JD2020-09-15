package by.it.yemialyanava.jd01_14;
/*В классе TaskC нужно выполнить следующие шаги:
         Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
        формате file:имя_файла или dir:имя_каталога.
         Продублировать вывод в консоль в файл resultTaskC.txt*/

import java.io.File;

public class TaskC {

    private static final String TEXT_DATA = "text.txt";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_С = "resultTaskС.txt";

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
        String textName = getPath(TaskC.class) + TEXT_DATA;



        /*public static void main(String a[]){
            File file = new File("C:/MyFolder/");
            String[] fileList = file.list();
            for(String name:fileList){
                System.out.println(name);
            }
        }*/



    }

}
