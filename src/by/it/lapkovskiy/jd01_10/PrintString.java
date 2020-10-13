package by.it.lapkovskiy.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = java.lang.String.class;
        Method[] methods = structString.getDeclaredMethods();
        StringBuilder out = new StringBuilder();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                //System.out.println(method.toString());
                if(out.indexOf(method.getName())<0 && method.getName()!="formatted"){
                    out.append(method.getName() + " ");
                    System.out.println(method.getName());
                }
            }
        }
    }
}
