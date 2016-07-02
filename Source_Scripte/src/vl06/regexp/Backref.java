package vl06.regexp;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */

public class Backref {
    public static void main(String[] args) {
        System.out.println("1212".matches("(\\d\\d)\\1"));
        System.out.println("1223".matches("(\\d\\d)\\1"));
        System.out.println("1212".matches("(?<wuppi>\\d\\d)\\k<wuppi>"));
    }
}
