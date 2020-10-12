package by.it.frolova.jd01_10;

/*TaskC1. Создайте класс BeanTester который в методе main с сигнатурой, допускающей Exception:
public static void main(String[] args) throws Exception создает экземпляр класса Bean (оператор
new Bean( ) для этого использовать нельзя!), а затем находит и запускает его методы,
помеченные созданной аннотацией с указанными в ней параметрами a и b. После каждого вызова
invoke на консоль выводится имя найденного метода и результат запуска.*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();

        Constructor<?> constructor = beanClass.getConstructor();
        Object o1 = constructor.newInstance();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param p = method.getAnnotation(Param.class);
                double result = (double)(method.invoke(o1, p.a(),p.b()));
                System.out.println(method.getName() + " " + result);
            }
        }
    }
}
