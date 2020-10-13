package by.it.dobrodey.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class BeanTester {


    public static void main(String[] args) throws Exception {
        //** TaskC1. Создайте класс BeanTester который в методе main с сигнатурой, допускающей
        // Exception: public static void main(String[] args) throws Exception создает экземпляр класса Bean
        // (оператор new Bean( ) для этого использовать нельзя!), а затем находит и запускает его методы,
        // помеченные созданной аннотациейс указанными в ней параметрами a и b.После каждого вызова
        // invoke на консоль выводится имя найденного метода и результат запуска

        Class<Bean> beanClass = Bean.class;
        Object o = beanClass.getDeclaredConstructor().newInstance();
        Method[] beanClassMethods = beanClass.getDeclaredMethods();

        for (Method method : beanClassMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);

                int a = annotation.a();
                int b = annotation.b();
                System.out.println("Имя метода: " + method.getName() + " Результат запуска: " + method.invoke(o, a, b));
            }
        }
    }
}


