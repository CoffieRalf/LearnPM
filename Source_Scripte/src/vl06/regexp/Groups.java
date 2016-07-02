package vl06.regexp;

/**
 * @author Carsten Gips
 * @since 25.02.2016
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static void main(String[] args) {
        String s = "A 12 A 45 A";

        Pattern p = Pattern.compile(".*((\\d+)\\s*A).*");
        Matcher m = p.matcher(s);

        System.out.println("Suchstring: '" + s + "'");
        System.out.println("Pattern:    '" + p.toString() + "'");
        System.out.println("Matcher:    '" + m.toString() + "'\n");

        if (m.matches()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("=> Gruppe " + i + ": '" + m.group(i) + "'");
            }
        }
    }
}
