package vl05.arrays;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */

class A {
    void printInfo() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    void printInfo() {
        System.out.println("B");
    }
}

class C<T> {
}

public class X {
    public static void printInfo(A[] list) {
        for (A a : list) {
            a.printInfo();
        }
    }

    public static void main(String[] args) {
        A[] a = { new A(), new B() };
        B[] b = { new B(), new B() };

        printInfo(a);
        printInfo(b);

        Object[] x = new String[] { "Hello", "World", ":-)" };
        x[0] = "Hallo";
        x[0] = new Double(2.0); // Laufzeitfehler

        // String[] y = x; // String[] ist KEIN Object[]!

        C<String>[] strList; // Deklaration noch erlaubt
        // C<String>[] strList1 = new C<String>[2]; // Compilerfehler
        C<String[]> strList2 = new C<String[]>(); // OK :)
    }
}
