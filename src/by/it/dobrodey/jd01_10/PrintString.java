package by.it.dobrodey.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * TaskB2. Напишите программу PrintString, которая выводит на консоль только
 * имена (без модификаторов и сигнатур) всех нестатических(т.е. экземплярных)
 * методов стандартного класса String.
 */
public class PrintString {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (!(Modifier.isStatic(modifiers))) {
                System.out.println(method.getName());
            }
        }
    }
}