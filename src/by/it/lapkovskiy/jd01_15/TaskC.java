package by.it.lapkovskiy.jd01_15;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    public static LinkedList<File> path;
    public static void main(String[] args) {
        path = new LinkedList<>();
        path.add( new File(System.getProperty(USER_DIR)));
        getStartPath();
        Scanner sc = new Scanner(System.in);
        while (true){
           // System.out.print(getPath()+">");
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            if (input.equals("end")) {
                break;
            }
            if(input.equals("dir")){
                loadDir(new File(getPath()));
            }
            if(chars[0]=='c' && chars[1]=='d'){
                if(chars[3]=='.' && chars[4]=='.'){
                   if(path.size()>2)path.remove(path.peekLast());
                }
                 else{
                     String s = input.substring(3,input.length());
                     path.addLast(new File(s));
                }

            }

        }
    }
    public static void loadDir(File folder){
        try {
            File[] folderEntries = folder.listFiles();
            for (File entry : folderEntries)
            {
                if (entry.isDirectory())
                {
                    System.out.println("dir:"+entry.getName());
                    continue;
                }
                System.out.println("file:"+entry.getName());
            }
        }catch (Exception e){

        }
    }
    private static String getPath() {
        String p ="";
        for (File s: path) {
            p+=s.getPath() + File.separator;
        }
        return p ;
    }
    private static void getStartPath() {
        path.add(new File(SRC));
        path.add(new File("by"));
        path.add(new File("it"));
        path.add(new File("lapkovskiy"));
        path.add(new File("jd01_15"));
    }
}
