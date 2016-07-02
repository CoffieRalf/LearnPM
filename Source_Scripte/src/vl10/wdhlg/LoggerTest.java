package vl10.wdhlg;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class LoggerTest {
    public static void main(String[] args) {
        Logger l = Logger.getLogger(LoggerTest.class.getName());

        l.setLevel(Level.WARNING);
        // l.setLevel(Level.FINE);

        l.finest("logging - level finest");
        l.finer("logging - level finer");
        l.fine("logging - level fine");
        l.info("logging - level info");
        l.warning("logging - level warning");
        l.severe("logging - level severe");
        l.log(Level.INFO, "logging - level info");
    }
}
