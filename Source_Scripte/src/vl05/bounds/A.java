package vl05.bounds;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */
public class A<E extends Number> {
    // Obere Schranke: E muss Number oder Subklasse sein
    // => Zugriff auf Methoden aus Number moeglich

    public static void main(String[] args) {
        A<Double> a;
        A<Number> b;
        // A<String> c; // Fehler!!!
    }

}
