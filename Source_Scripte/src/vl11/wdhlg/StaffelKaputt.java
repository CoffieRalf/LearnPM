package vl11.wdhlg;

/**
 * @author Carsten Gips
 * @since 26.02.2016
 *
 */

public class StaffelKaputt extends Thread {
    private Object stab;

    StaffelKaputt(Object stab) {
        this.stab = stab;
    }

    @Override
    public void run() {
        while (true) {
            nimmStab();
            laufen();
            stabAbgeben();
        }
    }

    private void stabAbgeben() {
        synchronized (stab) {
            stab.notifyAll();
            System.out.println("Stab abgegeben " + Thread.currentThread().getName());
        }
    }

    private void nimmStab() {
        synchronized (stab) {
            System.out.println("Stab haben will " + Thread.currentThread().getName());
            try {
                stab.wait();
            } catch (Exception e) {
            }
            System.out.println("Stab hab! " + Thread.currentThread().getName());
        }
    }

    void laufen() {
        for (int i = 0; i < 10; i++) {
            System.out.println("laufe ... " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Object stab = new Object();

        StaffelKaputt l1 = new StaffelKaputt(stab);
        StaffelKaputt l2 = new StaffelKaputt(stab);
        StaffelKaputt l3 = new StaffelKaputt(stab);

        l1.start();
        l2.start();
        l3.start();
    }
}
