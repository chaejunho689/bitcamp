package operator;

public class Operator04 {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		boolean result;
		
		result = ( (num1 += 10) < 0 && (num2 += 10) > 0);
		System.out.println("result = " + result);
		System.out.println("num1  = " + num1 + " num2 = " + num2);
		System.out.println();
		// result = false
		// num1  = 10 num2 = 0
		
		result = ( (num1 += 10) < 0 && (num2 += 10) > 0);
		System.out.println("result = " + result);
		System.out.println("num1  = " + num1 + " num2 = " + num2);
		System.out.println();
		// result = false
		// num1  = 20 num2 = 0
		
		result = ( (num1 += 10) > 0 && (num2 += 10) > 0);
		System.out.println("result = " + result);
		System.out.println("num1  = " + num1 + " num2 = " + num2);
		System.out.println();
		// result = true
		// num1  = 30 num2 = 10

	}
}
