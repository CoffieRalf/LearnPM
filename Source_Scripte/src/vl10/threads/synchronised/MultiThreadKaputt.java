package vl10.threads.synchronised;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see nach einer Idee aus Krueger: "Handbuch der Java-Programmierung" (Listing
 *      23.11, 23.12)
 *
 */

public class MultiThreadKaputt implements Runnable {
    int val = 0;

    public int incrVal() {
        int erg = val;
        // Zeit schinden ;-)
        double x = 1.0, y = 0, z = 0;
        for (int i = 0; i < 1000000; ++i) {
            x = Math.sin((x * i % 35) * 1.13);
            y = Math.log(x + 10.0);
            z = Math.sqrt(x + y) + z;
        }
        // sollte reichen: schreibender Zugriff auf Resource
        val++;
        return erg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run(): " + incrVal());
        }
    }

    public static void main(String[] args) {
        MultiThreadKaputt x = new MultiThreadKaputt();

        System.out.println("main(): vor run()");
        Thread t1 = new Thread(x); // Zwei Threads auf dem *selben* Runnable
        Thread t2 = new Thread(x); // => konkurrierender Zugriff auf `val`
        t1.start();
        t2.start();
        System.out.println("main(): nach run()");
    }
}
