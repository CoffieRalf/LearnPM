package vl10.threads.creation;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class ThreadedKaputt extends Thread {
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
        ThreadedKaputt x = new ThreadedKaputt();

        System.out.println("main(): vor run()");
        x.run(); // run() tut's nicht
        x.start();
        // x.start(); // 2x start() geht nicht
        System.out.println("main(): nach run()");
    }
}
