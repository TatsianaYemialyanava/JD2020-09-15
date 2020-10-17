package by.it.sheremet.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    int a();

    int b();
}
