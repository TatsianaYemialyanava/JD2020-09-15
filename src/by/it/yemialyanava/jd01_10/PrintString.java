package by.it.yemialyanava.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structureString = String.class;
        Method[] methods = structureString.getDeclaredMethods();
        for (Method method: methods){
            int modifiers = method.getModifiers();
            if (!(Modifier.isStatic(modifiers))){
                String methodName = method.getName();
                System.out.println(methodName);
            }
        }
    }
}
