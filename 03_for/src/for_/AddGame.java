package for_;

import java.util.Random;
import java.util.Scanner;

public class AddGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int count = 1; //문제갯수 5개
		int point = 0;

		int onemore = 0; // 한번 더 기회 카운트
		boolean game_over = true; // false는 게임 종료, true는 게임 진행 가능
		
		
		
		while(game_over) {
		
			while(game_over && count <= 5) {
				
				
				int a = new Random().nextInt(99 - 10 + 1) + 10; // 정답 10~99
				int b = new Random().nextInt(99 - 10 + 1) + 10; // 정답 10~99
				int dab = a + b;
				
				System.out.print("[" + count +"] " + a + " + " + b + " = " );
				int user_dab = scan.nextInt(); 
				
				while (game_over && count <= 5) {
					if(user_dab == dab) {
						System.out.println("맞았다.");
						onemore = 0;
						count++;
						point++;
					
						break;
					} else {
						if(onemore < 2 ) {
							System.out.println("틀렸다.");
							System.out.println("한번 더 기회를 준다.");
							System.out.print("[" + count +"] " + a + " + " + b + " = " );
							user_dab = scan.nextInt();
							onemore = onemore + 1;
							if(user_dab != dab) {
								System.out.println("틀렸다.");
								System.out.println("정답은 " + dab + "이다.");              
								//game_over = false;
								count++;
								onemore = 1;
								break;
							}
		
						}
						onemore = 1;
						break;
					}
		
				}
			}
			System.out.println("점수는 " + point * 20 + "점 입니다.");

			System.out.println("또 할래? (Y/N)");
			String yn = scan.next(); 
			System.out.println(yn);
			if(yn.equals("Y") || yn.equals("y") ) {
				count = 1;
			} else if(yn.equals("N")  || yn.equals("n") ) {
				game_over = false;
				break;
			}
		}
			
		System.out.println("프로그램을 종료합니다.");
		
	}
}
/*
[문제] 덧셈 계산 (for, while, 다중 for)
- 10 ~ 99 사이의 난수를 2개 발생하여 합을 구하는 프로그램
- 5문제를 제공한다.
- 1문제당 점수 20점씩 처리한다.
- 틀리면 1번 더 기회를 주고, 2번 다 틀리면 답을 알려준다.
- y, n은 대소문자 상관없이 작성.
[실행결과]
[1] 25 + 36 = 50
틀렸다
[1] 25 + 36 = 59
틀렸다 정답은 xx

[2] 10 + 25 = 35
딩동뎅

[5] 78 + 95 = 89
틀렸다
[5] 78 + 95 = 173
딩동뎅

당신은 총 x 문제를 맞추어서 점수 xx점 입니다.

또 할래(Y/N) : A
또 할래(Y/N) : w
또 할래(Y/N) : n (= N)

프로그램을 종료합니다.
*/