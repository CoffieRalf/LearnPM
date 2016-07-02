package vl10.threads.waitnotify;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

class Stab {
    boolean inBesitz = false;

    public synchronized void nimm() {
        // geschützt: hier kommt nur einer gleichzeitig rein
        System.out.println("Stab haben will " + Thread.currentThread().getName());
        while (inBesitz) { // Stab schon bei jemanden in Besitz?
            try {
                wait(); // Falls ja: Dann warte "auf" dem Stab
            } catch (InterruptedException exc) {
            }
        }
        inBesitz = true; // Stab war frei; jetzt ist er meins
        System.out.println("Stab hab! " + Thread.currentThread().getName());
    }

    public synchronized void abgeben() {
        // geschützt: hier kommt nur einer gleichzeitig rein
        inBesitz = false; // Stab abgeben
        notifyAll(); // Alle aufwecken: Mir doch egal, wer weiter macht :)
        System.out.println("Stab abgegeben " + Thread.currentThread().getName());
    }
}

public class Staffel extends Thread {
    private Stab stab;

    Staffel(Stab stab) {
        this.stab = stab;
    }

    @Override
    public void run() {
        while (true) {
            takeShortNap();
            stab.nimm();
            laufen();
            stab.abgeben();
        }
    }

    void laufen() {
        for (int i = 0; i < 10; i++) {
            System.out.println("laufe ... " + Thread.currentThread().getName());
            takeShortNap();
        }
    }

    private void takeShortNap() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Stab stab = new Stab(); // Synchronisations-Objekt

        Staffel l1 = new Staffel(stab);
        Staffel l2 = new Staffel(stab);
        Staffel l3 = new Staffel(stab);

        l1.start();
        l2.start();
        l3.start();
    }
}
