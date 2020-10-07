package by.it.girovka.jd01_10;

import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
                for(Method method : methods){

                }

    }
}
