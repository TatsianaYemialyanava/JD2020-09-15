package by.it.fedorinhyk.jd01_14;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class TaskB {

    private static final String FILE_DATA="text.txt";
    private static final String SRC="src";
    private static final String USER_DIR="user.dir";
    private static final String RESULT_TASK_B="resultTaskB.txt";

    private static String getpath (Class<?> classname){
        String packagename=classname.getPackage().getName().replace(".", File.separator).concat(File.separator);
        String root=System.getProperty(USER_DIR);
        return root+File.separator+SRC+File.separator+packagename;
    }

    public static void main(String[] args) {
        String filename=getpath(TaskB.class)+FILE_DATA;
        ArrayList<String> list = new ArrayList<>();
        new Reader(filename) {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }
            @Override
            public void close() throws IOException {

            }
        };
    }

}
