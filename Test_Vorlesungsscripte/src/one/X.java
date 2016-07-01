package one;
public class X {
    void methode(int a) {
        System.out.println("non-generic");
    }

    <T> void methode(T a) {
        System.out.println("generisch");
    }

    public static void main(String[] args) {
        X x = new X();
        x.methode(3);
        x.methode(new Integer(4)); // Objekt und kein int
        x.methode("huhu");
    }
}
