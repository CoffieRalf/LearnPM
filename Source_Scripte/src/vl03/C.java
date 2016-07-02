package vl03;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Carsten Gips
 * @version 10.04.2016
 *
 */

@Documented // Mit @Documented geht die Annotation in die generierte JavaDoc
@interface MyFirstAnnotation {
}

@Retention(RetentionPolicy.RUNTIME) // Sichtbarkeit: SOURCE, CLASS, RUNTIME
@Target(ElementType.METHOD) // Wo erlaubt: TYPE, CONSTRUCTOR, METHOD, ...
@interface MySecondAnnotation {
    String value();
}

@Retention(RetentionPolicy.RUNTIME) // Sichtbarkeit: SOURCE, CLASS, RUNTIME
@Target(ElementType.TYPE) // Wo erlaubt: TYPE, CONSTRUCTOR, METHOD, ...
@interface MyThirdAnnotation {
    String author();

    int vl() default 1;
}

@MyFirstAnnotation
// @MySecondAnnotation // NUR an Methoden erlaubt
@MyThirdAnnotation(author = "Carsten Gips", vl = 3)
public class C {

    public static void main(String[] args) {
        // Vorgriff spaetere VL: Einsatz von Reflection
        System.out.println(C.class.isAnnotationPresent(MyFirstAnnotation.class));
        System.out.println(C.class.isAnnotationPresent(MySecondAnnotation.class));
        System.out.println(C.class.isAnnotationPresent(MyThirdAnnotation.class));
    }
}

@MySecondAnnotation("wuppie")
class D {
}

@MySecondAnnotation(value = "wuppie")
class E {
}
