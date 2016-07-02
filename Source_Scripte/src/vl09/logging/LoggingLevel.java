package vl09.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */
public class LoggingLevel {
    private static Logger log = Logger.getLogger(LoggingLevel.class.getName());

    public static void main(String[] argv) {
        // log.setLevel(Level.WARNING);
        // log.setLevel(Level.OFF);
        // log.setLevel(Level.ALL); // ??? :-)

        log.finest("level finest");
        log.finer("level finer");
        log.fine("level fine");
        log.config("level config");
        log.info("level info");
        log.warning("level warning");
        log.severe("level severe");
        log.log(Level.INFO, "log() mit info-level");
    }
}
