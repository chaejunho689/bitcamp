package array;

import java.util.Arrays;
import java.util.Collections;

public class Array01 {
	public static void main(String[] args) {
		int[] ar;	// 배열 선언  
		ar = new int[5];	// 배열 생성 

		ar[0] = 25;
		ar[1] = 36;
		ar[2] = 42;
		ar[3] = 17;
		ar[4] = 95;
		
		System.out.println("배열명 ar = " + ar);
		System.out.println("배열 크기 = " + ar.length);
		for(int i = 0; i < ar.length; i++) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		
		System.out.println("거꾸로 출력");
		for(int i = ar.length - 1; i >= 0 ; i--) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		
		System.out.println("\n홀수 데이터만 출력");
		for(int i = 0; i < ar.length; i++) {
			if(i % 2 == 1) {
				System.out.println("ar[" + i + "] = " + ar[i]);
			}
		}
		
		System.out.println("\n짝수 데이터만 출력");
		for(int i = 1; i < ar.length; i++) {
			if(i % 2 == 0) {
				System.out.println("ar[" + i + "] = " + ar[i]);
			}
		}
		
		System.out.println("\n오름차순 정렬");
		for(int i = 1; i < ar.length; i++) {
			if(i % 2 == 0) {
				System.out.println("ar[" + i + "] = " + ar[i]);
			}
		}
		
		System.out.println("\n오름차순 정렬");
		Arrays.sort(ar);
		for(int i = 0; i < ar.length; i++) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		
		System.out.println("\n확장형 for문");
		for(int data : ar) { //ar.length를 안 써도 배열크기만큼 for문이 돈다.
			System.out.print(data + " ");
		}
		
		
	}
}
