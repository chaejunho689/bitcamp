package multiArray;

import java.util.Scanner;

public class MultiArray02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] ar = new int[10][10];
		int num = 0;
		int k = 1;
		
		// 입력
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < 10; j++) {
				ar[i][j] = k;
				k++;
			}
		}
		
		// 출력
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
			}
		}

		k = ar.length * ar.length;
		// 입력
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < 10; j++) {
				ar[i][j] = k;
				k--;
			}
		}
		
		// 출력
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
			}
		}
	}
}
