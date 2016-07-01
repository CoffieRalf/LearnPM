package two;
class A {
    void printInfo() { System.out.println("A"); }
}
class B extends A {
    void printInfo() { System.out.println("B"); }
}
class C extends A {
    void printInfo() { System.out.println("C"); }
}

public class XX {
    public static void printInfo(A[] list) {
        for (A a : list) { a.printInfo(); }
    }
    public static void main(String[] args) {
        A[] a = { new A(), new B(), new C() };
        B[] b = { new B(), new B(), new B() };
        C[] c = { new C(), new C(), new C() };

        printInfo(a);
        printInfo(b);
        printInfo(c);
    }
}
