package array;

import java.util.Scanner;

public class Array03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("배열 크기 입력 : ");
		int size = scan.nextInt();
		
		int[] ar = new int[size];
		
		// 입력
		for(int i = 0; i < size; i++) {
			System.out.print("ar[" + i + "] 입력 : ");
			int user_input = scan.nextInt();
			ar[i] = user_input;
		}
		

		// 최댓값
		int max_num = ar[0];
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] > max_num) {
				max_num = ar[i];
			}
		}
		System.out.println("최대값 : " + max_num);
		
		// 출력
		System.out.print("배열 값 : ");
		for(int data : ar) {
			System.out.print(data + "\t");
		}
		
		int sum = 0;
		for(int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}
		// 합계
		System.out.println("\n합 = " + sum);
		
		
		
	}
}

/*
배열 크기 입력 : 3
ar[0] 입력 : 36
ar[1] 입력 : -25
ar[2] 입력 : 100

 */
