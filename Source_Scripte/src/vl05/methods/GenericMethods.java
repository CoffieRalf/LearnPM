package vl05.methods;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */
class X {
    public <T> T myst(T m, T n) {
        System.out.println("X#myst: T");
        return m;
    }

    // NICHT erlaubt wg. Typ-Löschung:
    // public <T1, T2> T1 myst(T1 m, T2 n) {
    // System.out.println("X#myst: T");
    // return m;
    // }

    public String myst(String m, String n) {
        System.out.println("X#myst: String");
        return m;
    }

    public int myst(int m, int n) {
        System.out.println("X#myst: int");
        return m;
    }
}

public class GenericMethods {
    public static void main(String[] args) {
        X x = new X();

        x.<String> myst("Essen", "lecker"); // Angabe Typparameter

        x.myst("Essen", 1); // String, Integer => T: Object
        x.myst("Essen", "lecker"); // String, String => T: String
        x.myst(1.0, 1); // Double, Integer => T: Number

        // Integer i = x.myst(1.0, 1); // Fehler!!!
        // Double d = x.myst(1.0, 1); // Fehler!!!
        Number n = x.myst(1.0, 1); // Double, Integer => T: Number

        x.myst("Hello World", "x");
        x.myst("Hello World", 1);
        x.myst(3, 4);
        x.myst(x, x);
        x.<X> myst(x, x);
        x.myst(x, 1);
        x.myst(3.0, 4);
        x.<Double> myst(3, 4);
    }
}
