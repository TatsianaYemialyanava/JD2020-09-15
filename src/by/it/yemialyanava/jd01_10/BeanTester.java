package by.it.yemialyanava.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> structureBean = Bean.class;
        Constructor<Bean>[] constructors = (Constructor<Bean>[]) structureBean.getDeclaredConstructors();

        Constructor noParamConstr = null;
        for (Constructor constructor : constructors){
            int parametrCount = constructor.getParameterCount();
            if (parametrCount == 0 ){
                    noParamConstr = constructor;
            }
        }
        Object objBean = noParamConstr.newInstance();

        Method[] methods = structureBean.getDeclaredMethods();
        for(Method method: methods){
            Param anno = method.getDeclaredAnnotation(Param.class);
            if (anno != null) {
                int firstarg = anno.a();
                int secondarg = anno.b();
                int modifiers = method.getModifiers();
                if (Modifier.isStatic(modifiers)) {
                    double result = (double) method.invoke(null, firstarg, secondarg);
                    System.out.println(method.getName() + " " + result);
                } else {
                    double result = (double) method.invoke(objBean, firstarg, secondarg);
                    System.out.println(method.getName() + " " + result);
                }
            }
        }
    }
}
