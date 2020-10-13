package by.it.dobrodey.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] declaredMethods = structMath.getDeclaredMethods();
        for (Method method : declaredMethods) {

            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers)){
                StringBuilder out = new StringBuilder();
                out.append("public ");
                if(Modifier.isStatic(modifiers)){
                    out.append("static ");
                    Class<?> returnType = method.getReturnType();
                    out.append(returnType).append(" ");
                    String methodName = method.getName();
                    out.append(methodName).append("(");
                    Class<?>[] types = method.getParameterTypes();
                    String delimiter="";
                    for (Class<?> type : types) {
                        out.append(delimiter)
                                .append(type.getSimpleName());
                        delimiter=",";
                    }
                    out.append(")");
                }
                System.out.println(out);
            }

        }
        Field[] mathFields = structMath.getFields();
        for (Field mathField : mathFields) {
            int modifiers = mathField.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder out = new StringBuilder();
                out.append("public ");
                if (Modifier.isStatic(modifiers)){
                    out.append("static ");
                    out.append(mathField.getType()).append(' ');
                    out.append(mathField.getName());

                }
                System.out.println(out);
            }
            }
        }
}
