package while_;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int result = (new Random().nextInt(100)) + 1; // 1~100까지의 난수 발생
	// 	int result = (int)(Math.random() * 100 + 1);
		System.out.println("1부터 100까지의 숫자가 발생했습니다. (" + result + ")");

		int count = 0;
		int user;
		do {
			System.out.print("정답 입력 : ");
			user = scan.nextInt();
			count++;
			if(user > result) {
				System.out.println(user + "보다 작은 숫자입니다.");
			} else if(user < result) {
				System.out.println(user + "보다 큰 숫자입니다.");
			} else {
				break;
			}
		} while(user != result);
		
		System.out.println("딩동댕..." + count + "번 만에 정답입니다.");
	}
}


/*
[문제] 숫자 맞추기 게임
- 숫자의 범위는 1 ~ 100 사이로 한다.
- 컴퓨터가 숫자를 발생하면 사용자가 맞추는 프로그램이다.

[실행결과]
1 ~ 100 사이의 숫자가 발생했습니다. (87)

숫자 입력 : 50
50보다 큰 숫자입니다.

숫자 입력 : 95
97보다 작은 숫자입니다.

~~~

숫자 입력 : 87
딩동뎅...x번만에 맞추셨습니다.
 */