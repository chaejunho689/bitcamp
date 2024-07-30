package for_;

import java.util.Scanner;

public class For05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = 0;
		if(x == 0) {
			while(x == 0) {
				System.out.print("x의 값 : ");
				x = scan.nextInt();
				if(x == 0) {
					System.out.println("게임을 종료합니다.");
					return;
				}
			}
		}
		int y = -1;
		if(y < 0) {
			while(y < 0) {
				System.out.print("y의 값 : ");
				y = scan.nextInt();
				if(y < 0) {
					System.out.println("0보다 큰 값을 입력해야 합니다.");
				}
			}
		}
		int result = x;
		for(int i = 1; i < y; i++) {
			result = result * x;
		}
		System.out.println(x + "의 " + y +"승 " + result);
		System.out.println("=== 프로그램 종료 ===");
	}
}
/*
[문제] x와 y의 제곱승을 구하시오 - while, for
- y의 값이 음수가 들어오면 다시 입력한다.
- x의 값이 0이 프로그램 종료한다. 

[실행결과]
x : 2
y : 5
2의 5승 32

x : 2
y : -2
y : 7
2의 7승 128

x : 0
프로그램을 종료합니다.
*/