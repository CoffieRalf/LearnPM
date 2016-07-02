package vl10.threads.intro;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class Traditional {
    int val = 0;

    public int incrVal() {
        return val++;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run(): " + incrVal());
        }
    }

    public static void main(String[] args) {
        Traditional x = new Traditional();

        System.out.println("main(): vor run()");
        x.run();
        System.out.println("main(): nach run()");
    }
}
