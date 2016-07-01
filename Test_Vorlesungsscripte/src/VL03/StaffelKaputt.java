package VL03;

/**
 * @author Carsten Gips
 * @since 14.06.2015
 *
 */

public class StaffelKaputt extends Thread {
    boolean Besitz = false ;
    private Object stab;
    StaffelKaputt(Object stab) { 
    	this.stab = stab; 
    	}
    public void run() {
    	takenap();
    	nimmStab();
    	laufen(); 
    	stabAbgeben();
    	}
    
    
    
    private synchronized void nimmStab() {
    	while(Besitz){
            try { 
            	System.out.println("Stab nehmen"); 
            	wait();
            	
            	} 
            catch (Exception e) {          	
            }
            
    	}Besitz=true;	
        }
    private synchronized void stabAbgeben() {
    	System.out.println("Abgeben");       
        	notifyAll(); 
        	Besitz = false; 
        }
    void laufen() {
    	System.out.println("laufe ... "); 
    	}
    void takenap(){   	
    	try {
        	System.out.println("schlafen ... "); 
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
        Object stab = new Object();
        StaffelKaputt l1 = new StaffelKaputt(stab);
        StaffelKaputt l2 = new StaffelKaputt(stab);
        l1.start(); 
        l2.start();
    }}