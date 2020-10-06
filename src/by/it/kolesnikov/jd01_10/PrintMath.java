package by.it.kolesnikov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method: methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder out = new StringBuilder();
                out.append("public ");
                if(Modifier.isStatic(modifiers))
                    out.append("static ");
                Class<?> returnType = method.getReturnType();
                out.append(method.getName()).append("(");
                Class<?>[] types = method.getParameterTypes();
                String delimeter ="";
                for (Class<?> type:types){
                    out.append(delimeter);
                }
                System.out.println(out);
            }
        }
    }
}
