package by.it.frolova.jd01_14;

import java.io.*;

class TaskA {

    public static final String USER_DIR = "user.dir";
    public static final String FILE_DATA = "dataTaskA.bin";

    public static void main(String[] args) {
        Class<TaskA> aClass = TaskA.class;
        String fileName = getPath(aClass) + FILE_DATA;
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                int n = -12345 / 2 + (int) (Math.random() * 12345);
                dataOutputStream.writeInt(n);
            }
            dataOutputStream.writeInt(90 + 89 * 256 + 88 * 256 * 256 + 87 * 256 * 256 * 256);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getPath(Class<TaskA> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + "src" + File.separator + packageName;
    }
}
