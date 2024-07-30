package switch_;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("a의 값 : ");
		int num1 = scan.nextInt();
		
		System.out.println("b의 값 : ");
		int num2 = scan.nextInt();
		
		System.out.println("c의 값 : ");
		int num3 = scan.nextInt();
		
		if(num1 > num2 && num1 < num3) {
			System.out.println(num2 + " " + num1 + " " + num3); 	
		} else if(num1 > num2 && num1 > num3) {						
			if(num2 > num3) {										
				System.out.println(num3 + " " + num2 + " " + num1);
			} else {
				System.out.println(num2 + " " + num3 + " " + num1);
			}
		} else if(num2 > num1 && num2 > num3) {
			if(num1 > num3) {
				System.out.println(num3 + " " + num1 + " " + num2);
			} else {
				System.out.println(num1 + " " + num3 + " " + num2);
			}
		} else {
			if(num1 > num2) {
				System.out.println(num2 + " " + num1 + " " + num3);
			} else {
				System.out.println(num1 + " " + num2 + " " + num3);
			}
		}
	}
}

/*
3개의 숫자(a,b,c)를 입력받아서 순서대로 출력하시오 (if문 사용하시오)

[실행결과]
a의 값 : 98
b의 값 : 90
c의 값 : 85

85 90 98

a의 값 : 75
b의 값 : 25
c의 값 : 36

25 36 75
*/