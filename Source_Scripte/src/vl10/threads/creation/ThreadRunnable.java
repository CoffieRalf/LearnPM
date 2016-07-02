package vl10.threads.creation;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class ThreadRunnable implements Runnable {
    int val = 0;

    public int incrVal() {
        return val++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run(): " + incrVal());
        }
    }

    public static void main(String[] args) {
        ThreadRunnable x = new ThreadRunnable();

        System.out.println("main(): vor run()");
        Thread t = new Thread(x); // Runnable "in" neuen Threads stecken
        t.start();
        System.out.println("main(): nach run()");
    }
}
