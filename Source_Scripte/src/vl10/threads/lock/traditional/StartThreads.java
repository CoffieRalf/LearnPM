package vl10.threads.lock.traditional;

/**
 * @author Carsten Gips
 * @since 26.04.2016
 *
 */

class Display extends Thread {
    private Object monitor;

    public Display(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("Display-Thread: warte auf Berechnungsergebnis");

            try {
                // Auf Daten vom Calulator-Thread warten
                // (gibt Lock auf gemeinsamen Monitor-Objekt so lange auf =>
                // Calulator-Thread bekommt Lock auf dem Monitor-Objekt)
                monitor.wait();
            } catch (InterruptedException e) {
                return; // Abbruch: Hier ging was schief!
            }

            // Daten "darstellen"
            System.out.println("Display-Thread: Ergebnis ist endlich da :-)");
        }
    }

}

class Calculator extends Thread {
    private Object monitor;

    public Calculator(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("Calculator-Thread: starte Berechung");

            try {
                Thread.sleep(2000); // lange Berechnung ;-)
            } catch (InterruptedException e) {
                return; // Abbruch: Hier ging was schief!
            }

            // Display-Thread benachrichtigen
            monitor.notify();

            System.out.println("Calculator-Thread: Berechnung beendet");
        }
    }
}

public class StartThreads {
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object(); // gemeinsames Monitor-Objekt

        Display displayThread = new Display(monitor);
        Calculator calculatorThread = new Calculator(monitor);

        displayThread.start();
        Thread.sleep(10); // DisplayThread muss vor CalculatorThread starten
        calculatorThread.start();
    }
}
