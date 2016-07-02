package vl10.threads.synchronised;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see aus Java-SE-Tutorial, Oracle.com, Trail Concurrency
 *
 */

class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public synchronized void bow(Friend bower) {
        System.out.format("%s: %s" + " has bowed to me!%n", this.name, bower.name);
        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.name);
    }
}

public class Deadlock {
    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
