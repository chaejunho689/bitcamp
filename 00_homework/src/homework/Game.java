package homework;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		int sciss = 1;
		int stone = 2;
		int paper = 3;
		int user_money = 1000;
		int computer_money = 1000;
		
		System.out.println("가위(1), 바위(2), 보자기(3) 입력 : ");
		int user = scan.nextInt();
		
		if (user < 1 || user > 3) {
			System.out.println("Error : 잘못 입력하였습니다.");
			System.out.println("게임을 종료합니다.");
		} else {
			int computer = (new Random().nextInt(3)) + 1; // 0~2까지의 난수 발생
			
			System.out.println("베팅 금액을 입력하세요 : ");
			int user_bat = scan.nextInt();
			if(user_bat > user_money || user_bat <= 0) {
				System.out.println("Error : 소지한 금액보다 많거나 잘못된 금액입니다.");
				System.out.println("게임을 종료합니다.");
			} else {
				System.out.println("결과를 보려면 Enter를 입력하세요.");
				int enteryn = System.in.read();

				if(enteryn == 13) {
					switch(user) {
					case 1 :
						if(computer == 2) {
							System.out.println("나는 가위, 컴퓨터는 바위");
							System.out.println("졌다.");
							user_money -= user_bat;
							System.out.println("현재 금액은 : " + user_money);
						} else if (computer == 3) {
							System.out.println("나는 가위, 컴퓨터는 보자기");
							System.out.println("이겼다.");
							user_money += user_bat;
							System.out.println("현재 금액은 : " + user_money);
						} else {
							System.out.println("나는 가위, 컴퓨터는 가위");
							System.out.println("비겼다..");
							System.out.println("현재 금액은 : " + user_money);
						}
						break;
					case 2 : 
						if(computer == 2) {
							System.out.println("나는 바위, 컴퓨터는 바위");
							System.out.println("비겼다..");
							System.out.println("현재 금액은 : " + user_money);
						} else if (computer == 3) {
							System.out.println("나는 바위, 컴퓨터는 보자기");
							System.out.println("졌다.");
							user_money -= user_bat;
							System.out.println("현재 금액은 : " + user_money);
						} else {
							System.out.println("나는 바위, 컴퓨터는 가위");
							System.out.println("이겼다.");
							user_money += user_bat;
							System.out.println("현재 금액은 : " + user_money);
						}
						break;
					case 3 :
						if(computer == 2) {
							System.out.println("나는 보자기, 컴퓨터는 바위");
							System.out.println("이겼다.");
							user_money += user_bat;
							System.out.println("현재 금액은 : " + user_money);
						} else if (computer == 3) {
							System.out.println("나는 보자기, 컴퓨터는 보자기");
							System.out.println("비겼다..");
							System.out.println("현재 금액은 : " + user_money);
						} else {
							System.out.println("나는 보자기, 컴퓨터는 가위");
							System.out.println("졌다.");
							user_money -= user_bat;
							System.out.println("현재 금액은 : " + user_money);
						}
						break;
					}
				} else {
					System.out.println("Enter를 입력하지 않아서, 게임을 종료합니다.");
				}
			}
		}
	}
}


/*
[문제] 가위 바위 보 게임
- 가위(1), 바위(2), 보자기(3)으로 설정한다.
- 컴퓨터는 난수 1 ~ 3 사이의 숫자를 발생한다.
- 기본 금액은 1000원을 기본으로 설정한다.

[실행결과]
가위(1), 바위(2), 보자기(3) 입력 : 1
배팅 금액 : 600

결과를 보시려면 Enter를 치세요

컴퓨터 바위, 나는 가위
ㅠㅠ..졌다
현재 금액은 400윈
*/