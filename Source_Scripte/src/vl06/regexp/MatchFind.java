package vl06.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */

public class MatchFind {
    public static void main(String[] args) {
        String a = "Hello World";
        boolean e;

        Pattern p = Pattern.compile("Hello");

        Matcher m = p.matcher(a);
        e = m.find();
        e = m.matches();

        m = p.matcher("Hello");
        e = m.find();
        e = m.matches();
    }
}
