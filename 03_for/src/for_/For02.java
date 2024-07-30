package for_;

import java.io.IOException;

public class For02 {
	public static void main(String[] args) throws IOException {
		int i;
		for(i = 1; i <= 9; i++) {
			System.out.println("2 * " + i + " = " + 2*i );
		}
		/*
		2 * 1 = 2
		2 * 2 = 4
		2 * 3 = 6
		2 * 4 = 8
		2 * 5 = 10
		2 * 6 = 12
		2 * 7 = 14
		2 * 8 = 16
		2 * 9 = 18
		*/
		
		System.out.println("단을 입력하세요.");
		int j = System.in.read(); 
		// -> 0 입력 시 48 아스키 코드로 들어옴
		j = j - 48; // 또는 j = j - '0'
		for(i = 1; i <= 9; i++) {
			System.out.println(j + " * " + i + " = " + j*i );
		}
		

	}
}
