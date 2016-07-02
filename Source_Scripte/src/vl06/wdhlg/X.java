package vl06.wdhlg;

/**
 * @author Carsten Gips
 * @version 25.02.2016
 *
 */
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
        x.methode(new Integer(4));
        x.methode("huhu");
    }
}
