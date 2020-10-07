package by.it.girovka.jd01_10;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)


public @interface Param {


    int b();

    int a();
}
