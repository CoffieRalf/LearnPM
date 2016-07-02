package vl09.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */
public class LoggingParent {
    private static Logger logA = Logger.getLogger("b.a");
    private static Logger logB = Logger.getLogger("b");
    private static Logger logBase = Logger.getLogger("");

    public static void main(String[] argv) {
        System.out.println("B ist Eltern von A: " + (logA.getParent() == logB));
        System.out.println("'' ist Eltern von B:  " + (logB.getParent() == logBase));

        logA.setLevel(Level.FINE);
        logB.setLevel(Level.SEVERE);
        // logBase.setLevel(Level.SEVERE);

        System.out.println("Log-Level A: " + logA.getLevel());
        System.out.println("Log-Level B: " + logB.getLevel());
        System.out.println("Log-Level Basis: " + logBase.getLevel());
        System.out.println("Log-Level Basis-Handler[0]: " + logBase.getHandlers()[0].getLevel());
        // logBase.getHandlers()[0].setLevel(Level.SEVERE);
        // logA.setUseParentHandlers(false);
        // logB.setUseParentHandlers(false);

        ConsoleHandler handlerA = new ConsoleHandler();
        handlerA.setLevel(Level.ALL);
        handlerA.setFormatter(new MyFormatter("A"));
        logA.addHandler(handlerA);

        ConsoleHandler handlerB = new ConsoleHandler();
        handlerB.setLevel(Level.ALL);
        handlerB.setFormatter(new MyFormatter("B"));
        logB.addHandler(handlerB);

        logA.fine("A: level fine");
        logA.info("A: level info");
        logA.warning("A: level warning");
        logA.severe("A: level severe");

        logB.fine("B: level fine");
        logB.info("B: level info");
        logB.warning("B: level warning");
        logB.severe("B: level severe");

        logBase.fine("ROOT: level fine");
        logBase.info("ROOT: level info");
        logBase.warning("ROOT: level warning");
        logBase.severe("ROOT: level severe");
    }
}
