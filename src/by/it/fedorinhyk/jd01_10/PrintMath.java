package by.it.fedorinhyk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> struct = Math.class;
        Method[] methods = struct.getDeclaredMethods();
        for (Method method : methods) {

            int mod = method.getModifiers();
            if (Modifier.isPublic(mod)) {
                StringBuilder out = new StringBuilder();
                out.append("public ");
                if (Modifier.isStatic(mod))
                    out.append("static ");
                Class<?> returnType = method.getReturnType();
                out.append(returnType.getSimpleName()).append(" ");
                out.append(method.getName()).append("(");
                Class<?>[] types = method.getParameterTypes();
                String delimiter = "";
                for (Class<?> type : types) {
                    out.append(delimiter).append(type.getSimpleName());
                    delimiter = ",";
                }
                out.append(")");
                System.out.println(out);
            }
        }
        Field[] Fields = struct.getFields();
        for (Field field : Fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder out = new StringBuilder();
                out.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    out.append("static ").append(field.getType()).append(" ").append(field.getName());
                }
                System.out.println(out);
            }
        }
    }
}
