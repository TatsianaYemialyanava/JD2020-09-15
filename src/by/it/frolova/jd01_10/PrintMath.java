package by.it.frolova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* TaskB1. Напишите программу PrintMath, которая выводит на консоль все публичные поля и
методы стандартного класса Math в следующем формате (тест потребует точное совпадение!):

public static float abs(float)
public static double pow(double,double)
и т.д. (если будут несовпадения тест укажет, что он ожидал) */

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structure = Math.class;
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder result = new StringBuilder();
                result.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    result.append("static ");
                }
                Class<?> returnType = method.getReturnType();
                result.append(returnType.getSimpleName()).append(' ').append(method.getName()).append('(');
                Class<?>[] parameterTypes = method.getParameterTypes();
                String delimiter = "";
                for (Class<?> parameterType : parameterTypes) {
                    result.append(delimiter).append(parameterType.getSimpleName());
                    delimiter = ",";
                }
                result.append(')');
                System.out.println(result);
            }

        }
        Field[] fields = structure.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder result = new StringBuilder();
                result.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    result.append("static ");
                }
                result.append(field.getType()).append(' ').append(field.getName());
                System.out.println(result);
            }
        }
    }
}

