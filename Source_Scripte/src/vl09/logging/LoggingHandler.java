package vl09.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */
public class LoggingHandler {
    private static Logger log = Logger.getLogger(LoggingHandler.class.getName());

    public static void main(String[] argv) {
        log.setUseParentHandlers(false); // ??? :-)

        // log.setLevel(Level.FINE);
        // log.setLevel(Level.ALL);

        ConsoleHandler handlerA = new ConsoleHandler();
        handlerA.setLevel(Level.ALL);
        handlerA.setFormatter(new MyFormatter("A"));
        log.addHandler(handlerA);

        ConsoleHandler handlerB = new ConsoleHandler();
        handlerB.setLevel(Level.FINER);
        handlerB.setFormatter(new MyFormatter("B"));
        log.addHandler(handlerB);

        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.info("info");
        log.warning("warning");
        log.severe("severe");
    }
}
