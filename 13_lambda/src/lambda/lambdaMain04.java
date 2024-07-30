package lambda;

class Person04 {
	public void execute(Compute02 compute02) {
		String result = compute02.calc(25,36);
		System.out.println(result);
	}
	
	public int mul(int x, int y) {
		return x * y;
	}
}

public class lambdaMain04 {
	public static void main(String[] args) {
		Person04 person04 = new Person04();
//		int result = x + y;
//		
		person04.execute((x, y) -> {
			int result = x + y;
			return x + "x " +  " +"  + y + "=" + result + (x+y);
		});
		
		person04.execute((x,y) -> x + "+" + y + " = " + (x+y));
		
		
		
						
	}
}
