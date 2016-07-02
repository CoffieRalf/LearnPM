package vl10.threads.waitnotify;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class StaffelKaputt extends Thread {
    private Object stab;
    boolean Besitz = false; 

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
            Besitz = false; 
            System.out.println("Stab abgegeben " + Thread.currentThread().getName());
        }
    }

    private void nimmStab() {
    	while(Besitz){
        synchronized (stab) {
            System.out.println("Stab haben will " + Thread.currentThread().getName());
            try {
                stab.wait();
            } catch (Exception e) {
            }
            System.out.println("Stab hab! " + Thread.currentThread().getName());
        }
        Besitz=true;
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

        l1.start();
        l2.start();
    }
}
