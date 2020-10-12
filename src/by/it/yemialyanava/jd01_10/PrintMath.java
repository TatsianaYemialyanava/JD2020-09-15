package by.it.yemialyanava.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method:methods){
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                StringBuilder out = new StringBuilder();
                out.append("public ");
                if (Modifier.isStatic(modifiers)){
                    out.append ("static ");
                    Class <?> retutnType = method.getReturnType();
                    out.append(retutnType.getSimpleName()).append(' ');
                    out.append(method.getName()).append("(");
                    Class <?>[] types = method.getParameterTypes();
                    String delimiter = "";
                    for (Class <?> type : types){
                        out.append(delimiter).append(type.getSimpleName());
                        delimiter = ",";
                    }
                    out.append(')');
                    System.out.println(out);
                }
            }
        }
        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields){
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)){
                StringBuilder outfield = new StringBuilder();
                outfield.append("public ");
                if (Modifier.isStatic(modifiers)){
                    outfield.append("static ");
                    Class<?> returnType = field.getType();
                    outfield.append(returnType.getSimpleName()).append(' ');
                    outfield.append(field.getName());
                    System.out.println(outfield);
                }
            }
        }
    }
}
