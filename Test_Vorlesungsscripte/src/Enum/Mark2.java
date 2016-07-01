package Enum;

public class Mark2{

public static void main(String args[]){
	drei2 myMark2 = drei2.X;
	System.out.printf("Enum: '%s', getName(): '%s', Feld n: '%s',"
			+ "Feld name: '%s'%n", myMark2, myMark2.getName(), myMark2.n,
			myMark2.name());	
	for(Mark2 m : Mark2.values()){
		System.out.println("Elements: %s, \tgetName(); '%s'%n",m, m.getName());
	}
}}


