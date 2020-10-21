package by.it.frolova.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;
/*Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
использовать класс File и поддерживать две команды консоли:
 команду cd - смена каталога (посмотрите пример: Win+R → cmd → cd \ → dir ). В тестах проверяются всего
две команды cd .. и cd имя_папки_в_текущем_каталоге
 команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
 команда end – завершение работы.
 Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.*/

public class TaskC {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    public static void main(String[] args) {
        String filename = getPath(TaskC.class);
        File path = new File(filename).getParentFile();
        List<File> addresses = new ArrayList<>();
        addresses.add(path);
        System.out.println(path);
        Scanner sc = new Scanner(System.in);

        while (true) {
            File parent = addresses.get(addresses.size() - 1);
            String input = sc.nextLine();
            if (input.equals("cd")) {
                path = parent;
                System.out.println(path);
                addresses.add(path);

            } else if (input.startsWith("cd")) {
                String dirName = input.split(" ")[1];
                if (dirName.equals("..")) {
                    path = parent.getParentFile();
                    System.out.println(path);
                    addresses.add(path);
                } else {
                    path = new File(parent, dirName);
                    if(path.exists() && path.isDirectory()){
                        System.out.println(path);
                        addresses.add(path);
                    }
                }
            } else if (input.equals("dir")) {
                path = parent;
                if (path.isDirectory()) {
                    for (File file : Objects.requireNonNull(path.listFiles())) {
                        dirInfoPrint(file);
                    }
                }
            } else if (input.equals("end")) {
                break;
            }
        }
    }

    private static void dirInfoPrint(File file) {
        try {
            Map<String, Object> attributes = Files.readAttributes(file.toPath(), "creationTime,size");
            Date dateNow = new Date(((FileTime) attributes.get("creationTime")).toMillis());
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy' ' hh:mm a");
            StringBuilder sb = new StringBuilder(formatForDateNow.format(dateNow));
            if (file.isDirectory()) {
                sb.append("  ").append("<DIR>");
            } else System.out.print("        ");
            sb.append("  ").append(attributes.get("size")).append("     ").append(file.getName());
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<TaskC> cClass) {
        String packageName = cClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName + cClass.getSimpleName();
    }
}
