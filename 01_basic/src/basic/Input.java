package basic;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); 
		
		System.out.print("정수형 데이터 입력 : ");
		int a = scan.nextInt();
		
		System.out.print("실수형 데이터 입력 : ");
		double b = scan.nextDouble();

		System.out.println(a + " + " + b + " = " + (a + b));
		
	}
}
