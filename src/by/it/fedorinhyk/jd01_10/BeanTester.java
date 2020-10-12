package by.it.fedorinhyk.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> structclass = Bean.class;
        boolean start= true;
        boolean stop= false;
        Method[] methods = structclass.getDeclaredMethods();
        Object object = structclass.getConstructor().newInstance();
        for (Method method : methods)
            if (method.isAnnotationPresent(Param.class) == start){
                Param anot = method.getAnnotation(Param.class);
                int a = anot.a();
                int b = anot.b();
                System.out.println(method.getName()+"="+method.invoke(object, a, b));
            }
    }
}
