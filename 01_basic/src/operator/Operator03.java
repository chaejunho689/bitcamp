package operator;

public class Operator03 {
	public static void main(String[] args) {
		int a = 5;
		a += 2;
		a *= 3;
		System.out.println("a = " + a); // a = 21
		
		a++;
		System.out.println("a = " + a); // 22
		
		int b = a++;
		System.out.println("a = " + a + " b = " + b); // a = 23 b = 22
		
		int c = ++a - b--; // 1. a = 24 ->  2. b = 22 -> 24 - 2 = c, 3. b-- = 21 
		System.out.println("a = " + a + " b = " + b + " c = " + c); // a = 24 b = 21 c = 2
		
		System.out.println("++a = " + a++); // ++a = 24
		System.out.println("a++ = " + ++a); // a++ = 25
		System.out.println("a = " +a); // a = 26
	}
}