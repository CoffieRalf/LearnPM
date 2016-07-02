
public class Studi extends Person{
	public String getInfo(Studi s){
		return "Studi";
	}	
	
	public static void main(String[] args) {
		Studi s = new Studi();
		Studi p = s;
		Person x = new Studi();
		Person y = s;
		
		System.out.println(s.getInfo(p));
		System.out.println(s.getInfo(s));
		System.out.println(p.getInfo(p));
		System.out.println(p.getInfo(s));
		System.out.println(x.getInfo(p));
		
		System.out.println(y.getInfo(p));
		
	}

}
