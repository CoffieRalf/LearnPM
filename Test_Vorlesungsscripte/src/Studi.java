
public class Studi extends Person{
	public String getInfo(Studi s){
		return "Studi";
	}	
	
	public static void main(String[] args) {
		Studi s = new Studi();
		Studi p = s;
		
		System.out.println(s.getInfo(p));
		System.out.println(s.getInfo(s));
		
	}

}
