package operator;

import java.util.Scanner;

public class Operator01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("현금 입력 : ");
		int money = scan.nextInt();
		
		int chun = money / 1000;;
		int money_temp = money % 1000;
		
		int bak = money_temp / 100;
		money_temp = money % 100;
		int sip = money_temp / 10;
		money_temp = money % 10;
		int ill = money_temp / 1;
	
		System.out.println("천원 : " + chun + "장");
		System.out.println("백원 : " + bak + "개");
		System.out.println("십원 : " + sip + "개");
		System.out.println("일원 : " + ill + "개");
	}
}

/*
[문제] 동전 교환
현금을 입력하여 천, 백, 십, 일의 개수를 구하시오

[실행결과]
현금 입력 : 5723
천원 : 5장
백원 : 7개
십원 : 2개
일원 : 3개
*/