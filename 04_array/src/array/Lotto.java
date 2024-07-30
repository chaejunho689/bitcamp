package array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("현금 입력 : ");
		int money = scan.nextInt();
		
		if(money < 1000) {
			System.out.println("돈이 부족합니다.");
			return;
		}
		int count = (money / 1000); //1000원 마다 로또 게임 횟수 결정
		int line = 1; // 생성된 로또 라인 갯수를 계산
		int[] lotto_array;
		lotto_array = new int[6];
	
		while(true) {
				for(int i = 0; i < lotto_array.length; i++) {
					lotto_array[i] = new Random().nextInt(45)+ 1; // 1~45까지의 난수 발생
					for(int j = 0; j < i; j++) {
						if((lotto_array[i] == lotto_array[j])) { //번호 중복이 아니라면 번호 확정
							i--;
							break;
						}
					}
				}
			// 로도 한줄 생성 완료 후 정렬 
			Arrays.sort(lotto_array);

			// 한줄 번호 출력
			for(int i = 0; i < lotto_array.length; i++) {
				System.out.print(lotto_array[i] + "\t");
			}
			
			// 5줄 마다 더블 개행 추가
			if(line % 5 == 0) {
				System.out.println("\n");
			} else { //아닐경우 그냥 개행
				System.out.println();
			}
			line++; // 5번째 줄 count
			count--; // 로또 생성 count
			if(count <= 0) {
				break;
			}
		}
	}
}

/*
[문제] 로또 프로그램 - 자동 번호
1. 1 ~ 45까지의 정수형 값을 가진 6개인 배열이다.
2. 중복된 숫자를 가지면 안된다.
3. 오름차순
4. 1줄당 1000원이다.
5. 출력시 5자리로 맞춘다.
6. 5줄마다 줄바꿈을 한다.

[실행결과]
돈 입력 : 3200
    2    4   19   39   43   44
   22   26   33   38   39   42
    5    6    8   25   35   45
    
현금 입력 : 7000    
    2    4   19   39   43   44
   22   26   33   38   39   42
    5    6    8   25   35   45
    3   14   23   30   34   35
   18   20   25   27   32   37

    1   16   32   34   41   42
    5    6   18   30   33   44
    
    */