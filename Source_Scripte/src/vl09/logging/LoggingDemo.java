package vl09.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */
public class LoggingDemo {
    private static Logger log = Logger.getLogger(LoggingDemo.class.getName());

    public static void main(String[] argv) {
        log.info("Und los ...");

        try {
            log.log(Level.WARNING, "Vorsicht!");
            int x = 0 / 0;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Mift! Das ging schief: ", e);
        }

        log.info("Wuppie Fluppie :-))");
    }
}
