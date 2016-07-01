
class A {
    public A foo1(A a) {
        System.out.println("A");
        return a;
    }
    public A foo2() {
        System.out.println("A");
        return new A();
    }
}

class B extends A {
    public B foo1(B b) {
        System.out.println("B");
        return b;
    }
    public B foo2() {
        System.out.println("B");
        return new B();
    }
}

public class CC {
    public static void main(String[] args) {
    	A a = new A();
        B b = new B();
        A c = new B();

        a.foo1(a);
        a.foo1(b);
        a.foo1(c);

        b.foo1(a);
        b.foo1(b);
        b.foo1(c);

        c.foo1(a);
        c.foo1(b);
        c.foo1(c);
        
        a.foo2();
        b.foo2();
        c.foo2();
        
    }
}