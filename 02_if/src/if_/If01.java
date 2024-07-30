package if_;

import java.util.Scanner;

public class If01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("데이터입력");
		int a = scan.nextInt();
		
		
		if(a >= 50) System.out.println(a + "는 50보다 크거나 같다.");
		System.out.println(a + "는 50보다 작다.");
		System.out.println();
		
		if(true) 
			if(true) System.out.println("A");
			else System.out.println("B");
		System.out.println("C");
		System.out.println();
		
		if(false) 
			if(false) System.out.println("A");
			else System.out.println("B");
		System.out.println("C");
		System.out.println();
		
		
		a = -1;
		if( a > 0) {
			if(a < 0) {
				System.out.println("2의 true");
			} else {
				System.out.println("2의 false");
			}
			System.out.println("1의 true");
		} else {
			System.out.println("1의 false");
		}

		
		
	}
}
