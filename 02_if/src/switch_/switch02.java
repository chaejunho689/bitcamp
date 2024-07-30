package switch_;

import java.io.IOException;
import java.util.Scanner;

public class switch02 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int num1 = scan.nextInt();

		System.out.println("숫자를 입력하세요.");
		int num2 = scan.nextInt();
		
		System.out.println("a의 값 :" + num1);
		System.out.println("b의 값 :" + num1);
	
		System.out.println("연산자(+,-,*,/)를 입력");
		char symbol = (char)System.in.read();
		System.in.read();
		
		int result = 0;
		int flag = 0;
		
		switch(symbol) {
		case ('+') : result = num1 + num2;
			break;
		case ('-') : result = num1 - num2;
			break;
		case ('/') : result = num1 / num2;
			break;
		case ('*') : result = num1 * num2;
			break;
		default : flag = 1;
		}
		
		switch(flag) {
		case (1) :
			System.out.println("연산자 error");
			break;
		case (0) :
			System.out.println(num1 + " " + symbol + " " + num2 + " = " + result);
		}
	}
}



/*
2개의 정수형 숫자와 연산자(+,-,*,/)를 입력하여 계산하시오
단, 정수형 숫자는 Scanner를 사용하고, 연산자는 System.in.read()를 사용하여 입력하시오

[실행결과]
a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : +

25 + 36 = xx

a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : /

25 / 36 = 0.6944444444444444

a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : #

연산자 error
*/