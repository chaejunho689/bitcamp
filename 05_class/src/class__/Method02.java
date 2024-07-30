package class__;

public class Method02 {

	public int sum(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int mul(int a, int b) {
		return a*b;
	}
	public double div(int a, int b) {
		return (double)a/b;
	}
	
	public static void main(String[] args) {
		Method02 m = new Method02();
		
		System.out.println("25 + 36 = " + m.sum(25,36) );
		System.out.println("25 - 36 = " + m.sub(25,36) );
		System.out.println("25 * 36 = " + m.mul(25,36) );
		System.out.println("25 / 36 = " + String.format("%.2f", m.div(25,36)) );
	}
}
