package multiArray;

import java.text.Format;

public class MultiArray04 {
	public static void main(String[] args) {
		// 배열 생성
		String name[] = {"홍길동", "프로도", "라이언"};
		int jumsu[][] = {{90, 96, 100, 0}, {100, 77, 76,0}, {75, 50, 45,0}};
		double avg[] = {0,0,0};
		char grade[] = {0,0,0};

		// 총점, 평균, 학점 계산
		for(int i = 0; i < jumsu.length; i++) {
			for(int j = 0; j < jumsu.length; j++) {
				jumsu[i][3] += jumsu[i][j];
				avg[i] = (double)jumsu[i][3] / 3; // 소수점 계산 위해서 double 형변환 필요함

				if(avg[i] >= 90) {
					grade[i] = 'A';
				} else if (avg[i] >= 80) {
					grade[i] = 'B';
				} else if (avg[i] >= 70) {
					grade[i] = 'C';
				} else if (avg[i] >= 60) {
					grade[i] = 'D';
				} else if (avg[i] < 60) {
					grade[i] = 'F';
				}
			}
		}


		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");
		// 출력
		for(int i = 0; i < jumsu.length; i++) {
			System.out.print(String.format("%s", name[i]) + "\t");

			for(int j = 0; j < jumsu[i].length; j++) { // 국, 영, 수 점수 출력
				System.out.print(String.format("%d", jumsu[i][j]) + "\t");
			}
			
			System.out.print(String.format("%.2f", avg[i]) + "\t"); // 평균 점수 출력
			System.out.print(String.format("%c", grade[i]) + "\n"); // 학점 출력
		}
		System.out.println("----------------------------------------------------");

	}
}

/*
[문제] 성적 계산

1. 공식
총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수
학점은 평균이 90이상이면 A
          80이상이면 B
          70이상이면 C
          60이상이면 D
그 외는 F

2. 평균은 소수이하 2째자리까지 출력        
          
----------------------------------------------------
이름 국어 영어 수학 총점 평균 학점
----------------------------------------------------
홍길동	90 95 100
프로도	100 89 76
라이언	75 80 48
----------------------------------------------------
 */
