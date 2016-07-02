package vl10.threads.synchronised;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carsten Gips
 * @since 26.04.2016
 *
 */

public class MultiThreadLockSync implements Runnable {
    int val = 0;
    private Lock waechter = new ReentrantLock(); // seit Java5

    public int incrVal() {
        int erg;

        waechter.lock();

        erg = val;
        // Zeit schinden ;-)
        double x = 1.0, y = 0, z = 0;
        for (int i = 0; i < 1000000; ++i) {
            x = Math.sin((x * i % 35) * 1.13);
            y = Math.log(x + 10.0);
            z = Math.sqrt(x + y) + z;
        }
        // sollte reichen: schreibender Zugriff auf Resource
        val++;

        waechter.unlock();

        return erg;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run(): " + incrVal());
        }
    }

    public static void main(String[] args) {
        MultiThreadLockSync x = new MultiThreadLockSync();

        System.out.println("main(): vor run()");
        Thread t1 = new Thread(x); // Zwei Threads auf dem *selben* Runnable
        Thread t2 = new Thread(x); // => konkurrierender Zugriff auf `val`
        t1.start();
        t2.start();
        System.out.println("main(): nach run()");
    }
}
