package if_;

import java.util.Scanner;

public class If01_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//65 A 97 a
		System.out.println("데이터입력");
		int input = scan.nextInt();
		int uppercase = input - 32;
		char text = (char)uppercase;
		
		System.out.println(text);
	}
}
