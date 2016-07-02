package VL03;

/**
 * @author Carsten Gips
 * @since 14.06.2015
 *
 */

public class StaffelKaputt extends Thread {
    private Object stab;
    boolean Besitz = false; 
    
    StaffelKaputt(Object stab){
    	this.stab = stab;
    	}
    
    public void run() {
    	while(true){
    	nimmStab(); 
    	laufen(); 
    	stabAbgeben();
    	}
    	}
    
    private void stabAbgeben() {
        synchronized (stab) { 
        	Besitz = false; 
        	stab.notifyAll();
        	System.out.println("abgeben ... ");
        	}
    }
    
    private void nimmStab() {
    	while(Besitz){
        synchronized (stab) {
        	System.out.println("haben will ... ");
            try {
            	stab.wait(); 
            	
            }catch (Exception e) { 
            	
            }
            System.out.println("hab ... ");
        }Besitz=true;
        }
    }
    void laufen() { 
    	System.out.println("laufe ... "); 
    	}
    
    public static void main(String[] args) {
        Object stab = new Object();
        StaffelKaputt l1 = new StaffelKaputt(stab);
        StaffelKaputt l2 = new StaffelKaputt(stab);
        l1.start(); 
        l2.start();
    }}