package three;
import java.util.Arrays;
import java.util.List;

class A {
    void printInfo() { System.out.println("A"); }
}
class B extends A {
    void printInfo() { System.out.println("B"); }
}
class C extends A {
    void printInfo() { System.out.println("C"); }
}

public class XXX {
    public static void printInfo(List<A> list) {
        for (A a : list) { a.printInfo(); }
    }
    public static void main(String[] args) {
        A[] a = { new A(), new B(), new C() };
        B[] b = { new B(), new B(), new B() };
        C[] c = { new C(), new C(), new C() };

        List<A> x = Arrays.asList(a);  printInfo(x);
        List<A> y = Arrays.asList(b);  printInfo(y);
        printInfo(Arrays.asList(c));
    }
}
