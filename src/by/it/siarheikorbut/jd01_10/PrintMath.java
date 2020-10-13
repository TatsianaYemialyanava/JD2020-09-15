package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10 ( B1 )</a>
 */

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                System.out.println(method);
        }
    }
}
