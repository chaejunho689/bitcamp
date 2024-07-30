package homework;

import java.util.Scanner;

public class SungjukArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 인원수 입력하여 name[인원수] 결정
		System.out.print("인원 수를 입력하세요 : ");
		int count = scan.nextInt();
		String name[] = new String[count];
		
		// 각 인원의 대한 subjectCnt 배열길이 결정 
		// subject와 score는 가변길이로 생성한 후, 아래 인원별 입력 단계에서 초기화한다.
		int[] subjectCnt = new int[count];
		int subjectCnt_temp = 0;
        String[][] subject = new String[count][];
        int[][] score = new int[count][];

		int[] sum = new int[count];
		double[] avg = new double[count];
		
		// 이름은 인원수(count) 만큼 반복
		for(int j = 0; j < count; j++) {
			System.out.print("이름을 입력하세요 : ");
			name[j] = scan.next();
			
			System.out.print("과목 수를 입력하세요 : ");
			subjectCnt_temp = scan.nextInt();
			subjectCnt[j] = subjectCnt_temp;
			
           // 각 사람의 과목명과 점수 배열 동적 생성
            subject[j] = new String[subjectCnt_temp];
            score[j] = new int[subjectCnt_temp];
			
			// 각 사람의 과목수 만큼, 과목명과 점수 입력 반복
			for(int i = 0; i < subjectCnt_temp; i++) {
				System.out.print("과목명을 입력하세요 : ");
				subject[j][i] = scan.next();
			}
			
			// 각 사람의 과목수 만큼, 과목명과 점수 입력 반복
			for(int i = 0; i < subjectCnt_temp; i++) {
				System.out.print(subject[j][i] + "의 점수를 입력하세요 : ");
				score[j][i] = scan.nextInt();
				sum[j] += score[j][i]; // 점수 입력하면서 곧바로 각 사람당 합산 점수 바로 계산하여 배열 저장 
			}
		}

		// 평균 점수 계산
		for(int i = 0; i < count; i++) {
			avg[i] = (double)sum[i] /  subjectCnt[i];
		}
		
		// 성적표 출력
		for(int j = 0; j < count; j++) { // 인원수
			System.out.println();
			System.out.print("이름"+ "\t");

			for(int i = 0; i < subjectCnt[j]; i++) {
				System.out.print(subject[j][i]);
				System.out.print("\t");
			}
			System.out.print("총점");
			System.out.print("\t평균 \n");
			System.out.print(name[j] + "\t");

			for(int i = 0; i < subjectCnt[j]; i++) {
				System.out.print(score[j][i]);
				System.out.print("\t");
			}
			System.out.print(sum[j]);
			System.out.print("\t" + String.format("%.2f", avg[j]));
			System.out.println();

		}
		
		

	}
}

/*
[문제] 성적 계산
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 : 2 (cnt)

이름 입력 : 홍길동 (name)
과목수 입력 : 2   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
국어 점수 입력 : 95 (jumsu)
영어 점수 입력 : 100
---------------------
이름 입력 : 이기자
과목수 입력 : 3
과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 과학
국어 점수 입력 : 95
영어 점수 입력 : 100
과학 점수 입력 : 90
---------------------

이름     국어  영어   총점     평균
홍길동    95  100   xxx  xx.xx

이름 국어  영어   과학    총점      평균
이기자 95   100   90 xxx      xx.xx
*/