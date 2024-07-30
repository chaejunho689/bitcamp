package for_;

import java.util.Random;

public class For04 {
	public static void main(String[] args) {
		int row; //로우 갯수 설정
		int column; // 컬럼 갯수 설정 
 		int count = 0; //A의 갯수를 카운트한다.
		

		for(column = 1; column <= 10; column++) {
			for(row = 1; row <= 10; row++) {
				int alpa = new Random().nextInt(90 - 65 + 1) + 65;
				System.out.print((char)alpa + "\t");
				if((char)alpa == 'A') {
					count++;
				}
			}
			System.out.println();
		}	
		System.out.println("A의 갯수는 " + count + "입니다.");
	}
}

/*
대문자(A~Z)를 100개 발생하여 출력하시오
- 1줄에 10개씩 출력
- 100개중에서 A가 몇개 나왔는지 개수를 출력

[실행결과] 10x10
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

A의 개수 = 6
*/