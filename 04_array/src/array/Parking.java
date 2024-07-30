package array;

import java.util.Random;
import java.util.Scanner;

public class Parking {
	public static void main(String[] args) {
		boolean[] arr = new boolean[5];
		Scanner scan = new Scanner(System.in);
		

		// 주차장 입출차 정보 랜덤으로 생성 
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextBoolean();
		}
		
		System.out.println();
		System.out.println(
				"주차장 관리 프로그램 \n" +
				"************** \n" +
				"   1. 입차 \n" +
				"   2. 출차 \n" +
				"   3. 리스트 \n" +
				"   4. 종료 \n" +
				"************** \n" 
				);
		
		while(true) {
			System.out.print("메뉴 입력 : ");
			int menu_num = scan.nextInt();
			boolean flag = false;
			
			switch(menu_num) {
				case 1 : // 입차하기
					System.out.print("위치 입력 : ");
					int in_car = scan.nextInt() -1;
					
					if(arr[in_car]) {
						System.out.println(in_car+1 + "위치에 이미 주차되어 있습니다.");
					} else {
						System.out.println(in_car+1 + "위치에 주차되어 있지 않습니다.");
						arr[in_car] = true;
						System.out.println(in_car+1 + "위치에 입차 완료");

					}
					break;

				case 2 : // 출차하기 
					System.out.print("위치 입력 : ");
					int out_car = scan.nextInt() -1;
					
					if(arr[out_car]) {
						System.out.println(out_car+1 + "위치에 주차되어 있습니다.");
						arr[out_car] = false;
						System.out.println(out_car+1 + "위치에서 출차 완료");
					} else {
						System.out.println(out_car+1 + "위치에 주차되어 있지 않습니다.");
					}
					break;
	
				case 3 : // 입출자 정보 보기
					for(int i = 0; i < arr.length; i++) {
						System.out.print(i+1 + "번 자리 : " + arr[i] + "\n");
					}
					break;
					
				case 4 : flag = true; break;
				default : System.out.println("잘못 입력했습니다.");
			}
			
			if(flag == true) {
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
}

/*
주차장 관리 프로그램
**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
  메뉴 : 

[1번인 경우]
위치 입력 : 3
3위치에 입차 / 이미 주차되어있습니다

[2번인 경우]
위치 입력 : 4
4위치에 출차 / 주차되어 있지않습니다

[3번인 경우]
1위치 : true
2위치 : false
3위치 : true
4위치 : false
5위치 : false
*/