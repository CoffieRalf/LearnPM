interface ISeltsam { 
	int machWas(String s); 
	}

class A implements ISeltsam {
    public int machWas(String s) {
    	System.out.println("Class A");
		return 0;

    }
}
//class B implements ISeltsam { 
//	System.out.println("Class B"); 
//}

class Jemand {
    ISeltsam seltsam;
    Jemand(ISeltsam s) { seltsam = s; }
    int machAuchMalWas(String s) {
    	System.out.println("Class Seltsam");
        return seltsam.machWas(s);
    }
    
    
    //Hauptmethode
    //
    public static void main(String[] args) {
        Jemand j = new Jemand( new A() );
        j.machAuchMalWas("Huhu (main)");
    }
}
