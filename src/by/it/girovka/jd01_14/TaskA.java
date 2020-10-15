package by.it.girovka.jd01_14;

import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        Class <TaskA> aClass = TaskA.class;
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage.getName());
    }



}
