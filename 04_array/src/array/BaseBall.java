package array;

import java.util.Random;
import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		int[] com = new int[3];
		int[] user = new int[3];
		
		Scanner scan = new Scanner(System.in);
		String yn;
		// 게임 실행 여부 선택
		do {
			System.out.print("게임을 실행하시겠습니까(Y/N) : ");
			yn = scan.next(); 
		} while(!yn.equals("Y") && !yn.equals("y") && !yn.equals("N") && !yn.equals("n"));
		
		if(yn.equals("Y") || yn.equals("y")) {
			// 컴퓨터 난수 발생. 중복은 다시 생성한다.
			for(int i = 0; i < com.length; i++) {
				com[i] = new Random().nextInt(9) + 1;
				for(int j = 0; j < i; j++) {
					if((com[i] == com[j])) { //번호 중복이 아니라면 번호 확정
						i--;
						break;
					}
				}
			}
			
			while(true) { 
				// 유저 입력 부분. charAt을 통해 문자열을 숫자로 변환 및 각각을 배열에 저장한다.
				System.out.print("숫자 3자리를 입력하세요 : ");
				String user_input = scan.next();
				for(int i = 0; i < user.length; i++) {
					user[i] = user_input.charAt(i) - 48;
				}
				
				int count_ball = 0;
				int count_strike = 0;
				
				// 스트라이크 카운트
				for(int i = 0; i < com.length; i++) {
					if(com[i] == user[i]) {
						count_strike++;
					}
				}
				
				// 볼 카운트
				for(int i = 0; i < com.length; i++) {
					for(int j = 0; j < com.length; j++) {
						if((com[i] == user[j]) && i != j) {
							count_ball++;
						}
					}
				}
		
				// 컴퓨터난수값
				System.out.print("컴퓨터 :\t");
				for(int i = 0; i < com.length; i++) {
					System.out.print(com[i]);
				}
				System.out.println();
				// 유저값
				System.out.print("유저 :\t");
				for(int i = 0; i < user.length; i++) {
					System.out.print(user[i]);
				}
				
				System.out.println();
				System.out.println(count_strike+"스트라이크 "+ count_ball+"볼");
			}
		}
		System.out.println("게임을 종료합니다.");
	}
}

/*

[문제] 야구게임
크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
- 발생한 난수를 맞추는 게임
- 난수는 중복을 제거한다.

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : u
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123
0스트라이크 0볼

숫자입력 : 567
0스트라이크 2볼

숫자입력 : 758
1스트라이크 2볼
...

숫자입력 : 785
3스트라이크 0볼

프로그램을 종료합니다.

*/