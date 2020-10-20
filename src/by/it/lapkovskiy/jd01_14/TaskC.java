package by.it.lapkovskiy.jd01_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TaskC {
    private static final String USER_DIR = "user.dir";
    private static final String RESULT = "resultTaskC.txt";
    private static final String SRC = "src";

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(getPath()+File.separator+"jd01_14"+File.separator+RESULT);
        loadDir(new File(getPath()),fileOutputStream);
    }
    public static void loadDir(File folder, FileOutputStream fileOutputStream){
        try {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                System.out.println("dir:"+entry.getName());
                fileOutputStream.write(("dir:"+entry.getName()+"\n").getBytes());
                loadDir(entry,fileOutputStream);
                continue;
            }
            System.out.println("file:"+entry.getName());
            fileOutputStream.write(("file:"+entry.getName()+"\n").getBytes());
        }
        }catch (Exception e){

        }
    }
    private static String getPath() {
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator+"by"+File.separator+"it"+File.separator+"lapkovskiy"+File.separator;
    }
}
