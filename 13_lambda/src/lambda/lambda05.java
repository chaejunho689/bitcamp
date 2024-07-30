package lambda;

class Calculator {
	public static String staicMehthod(int x, int y) {
		return x + " + " + y + " = " + (x+ y);
	}
	public String non_staicMehthod(int x, int y) {
		return x + " + " + y + " = " + (x+ y);
	}
}

public class lambda05 {
	public static void main(String[] args) {
		Person04 person04 = new Person04();

		person04.execute((x+y) -> Calculator.staicMehthod(x, y));
		person04.execute(Calculator :: staicMehthod);

		
		Calculator calculator = new Calculator();

	}
}
