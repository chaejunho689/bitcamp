package basic;

import java.util.Random;
import java.text.Format;

public class Variable3 {
	public static void main(String[] args) {
		int big = Math.max(25, 36);
		System.out.println("큰 값 = " + big);
		
		double small = Math.min(12.7, 78.5);
		System.out.println("작은 값 = " + small);
		
		double power = Math.pow(2, 5);
		System.out.println("2의 5승 = " + power);
		
		double random = Math.random();
		System.out.println("난수 = " + random);

		double b = new Random().nextDouble();
		System.out.println(b);
		
		double a = new Random().nextDouble() * 100;
		int c = (int)a;
		System.out.println(a);
		System.out.println(c);
		
		int var1 = 65;
		int var2 = 90;

		int var3 = (int)(Math.random() * (var2-var1+1) + var1);
		System.out.println(var3);

		

	}
}
