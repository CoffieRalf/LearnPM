package vl07;

/**
 * @author Carsten Gips
 * @version 25.02.2016
 *
 */
public class FinalDemo {

    public static void main(String[] args) {
        int i = 2;
        final int j = 3;
        final int k;
        i = 3;
        j = 4; // Compilerfehler
        k = 5;
        k = 6; // Compilerfehler
    }

}
