package basic;

import java.text.DecimalFormat;

public class Compute {
	public static void main(String[] args) {
		short a = 320;
		short b = 258;

		int sum = a + b;
		int sub = a - b;
		int mul = a * b;	
		int mul2 = a * b;	
		double div = (double)a / b;
		double div2 = (double)a / b;

		
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.println(a + " * " + b + " = " + new DecimalFormat().format(mul2));
		System.out.println(a + " / " + b + " = " + div);
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div2));
	}
}
