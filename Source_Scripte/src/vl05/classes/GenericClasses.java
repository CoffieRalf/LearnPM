package vl05.classes;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */
class A<T> {
    // T kann in Klasse A *fast* wie Klassenname verwendet werden
    private T x;

    public T foo(T t) {
        System.out.println("A#foo");
        return t;
    }
    public int foo(int i){
    	System.out.print("A#int");
    	return i;
    }
}

public class GenericClasses {
    public static void main(String[] args) {
        A<String> a = new A<String>();
        A<Integer> b = new A<>(); // seit Java 1.7: "Diamond Operator"

        a.foo("wuppie");
        b.foo(1);
        // b.foo("huhu"); // Fehlermeldung vom Compiler
    }
}
