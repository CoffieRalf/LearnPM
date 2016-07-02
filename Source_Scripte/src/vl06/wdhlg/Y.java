package vl06.wdhlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Carsten Gips
 * @version 25.02.2016
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

public class Y {
    public static void printInfo1(A[] list) {
        for (A a : list) {
            a.printInfo();
        }
    }

    public static void printInfo2(List<A> list) {
        for (A a : list) {
            a.printInfo();
        }
    }

    public static void main(String[] args) {
        A[] a = { new A(), new B() };
        printInfo1(a);

        B[] b = { new B(), new B() };
        printInfo1(b);

        List<A> x = Arrays.asList(a);
        printInfo2(x);

        List<B> y = Arrays.asList(b);
        printInfo2(y);

        x = new ArrayList<A>();
        x = new ArrayList<B>();
    }
}
