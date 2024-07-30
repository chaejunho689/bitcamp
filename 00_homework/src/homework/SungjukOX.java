package homework;

import java.util.Scanner;

public class SungjukOX {
	static final String jung = "11111"; // final로 입력하면 상수화 됨.(불변값)

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		// static final의 jung을 배열화 한다. 배열 만들어서 저장.
		// 입력된 String을 char로 한글자씩 변환하여 저장한다.
		char dab[]  = new char[5];
		for(int i = 0; i < 5; i++) { 
			dab[i] = jung.charAt(i);
		}
		
		// 인원수 입력하여 name[인원수]과 ox[인원수][] 결정
		System.out.print("인원 수를 입력하세요 : ");
		int count = scan.nextInt();
		
		char[][] ox = new char[count][5]; // 입력한 정답(숫자)를 저장
		char[][] ox_save = new char[count][5]; // 각 사람의 대한 OX 저장
		int[] score = new int[count]; // 정답 'O'이면 +20점 저장

		String name[] = new String[count];
		
		// 인원수(count) 만큼 이름, 정답 입력을 반복한다.
		for(int i = 0; i < count; i++) {
			System.out.print("이름 입력 : ");
			name[i] = scan.next();
			
			System.out.print("정답 입력 : ");
			String user_input = scan.next();
			
			// 입력된 String을 char로 한글자씩 변환하여 저장한다.
			for(int j = 0; j < 5; j++) { // i -> 5 문제(5개)만큼 반복한다.
				ox[i][j] = user_input.charAt(j);
			}
		}

		// 인원수만큼 반복하여, 정답 맞는지 체크하여 O, X와 스코어 저장
		for(int j = 0; j < count; j++) { // j->count 인원수만큼 반복한다.
			for(int i = 0; i < 5; i++) { // i -> 5 문제(5개)만큼 반복한다.
				if(dab[i] == ox[j][i]) {
					ox_save[j][i] = 'O';
					score[j] += 20;
//					System.out.println("dab : "+ dab[j] + " \\ ox: " + ox[j][i] + " \\ save :" + ox_save[j][i]);
				} else {
					ox_save[j][i] = 'X';
//					System.out.println("dab : "+ dab[j] + " \\ ox: " + ox[j][i] + " \\ save :" + ox_save[j][i]);
				}
			}
		}
		

		// 성적표 출력
		System.out.println("*********************** 성적표 ***********************");
		System.out.println("이름\t1\t2\t3\t4\t5\t점수");
		for(int j = 0; j < count; j++) { // j->count 인원수만큼 반복한다.
			System.out.print(name[j] + "\t");
			for(int i = 0; i < 5; i++) { // i -> 5 문제(5개)만큼 반복한다.
				System.out.print(ox_save[j][i]);
				System.out.print("\t");
			}
			System.out.print(score[j]);
			System.out.println();
		}
		System.out.println("****************************************************");

		

	}
}
/*
정답입력방식
1~5번의 답은 "11111"
사용자가 답안지입력: "11111" 식으로 연속입력하는 방식
사용자가 답안지입력: "12311" 라고 입력하면 , 2개 틀림
사용자 :     "O X X O O" 점수 : 몇점

[문제] 성적처리 프로그램
- 5문제는 사지선다형 문제이다
- 정답은 "11111"
  static final String jung = "11111"; //상수화
- 1문제당 20점씩 한다.
  
[실행결과]
인원수 입력 : 2

이름 입력 : 홍길동
답안지 입력 : 12311

이름 입력 : 코난
답안지 입력 : 11311

 *** 성적표 ***
이름 1 2 3 4 5	점수
홍길동O X X O O	60
코난 O O X O O	80
*/


