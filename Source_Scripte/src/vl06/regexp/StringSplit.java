package vl06.regexp;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */

public class StringSplit {
    public static void main(String[] args) {
        String a = "boo:and:foo";
        String[] e;
        boolean b;

        e = a.split(":");
        e = a.split("o");
        e = a.split("b");

        b = a.matches(" ");
        b = a.matches("boo:and:foo");
        b = a.matches("boo");
    }
}
