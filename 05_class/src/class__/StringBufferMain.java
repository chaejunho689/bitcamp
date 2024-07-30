package class__;

import java.util.Scanner;
public class StringBufferMain {

	private int dan;
//	private static int dan2;
	
	public StringBufferMain() {
		Scanner scan = new Scanner(System.in);
		System.out.println("원하는 단을 입력 : ");
		dan = scan.nextInt();
		
	}
	
	public void output() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i <= 9; i++) {
//			System.out.println(dan);
			
			buffer.append(dan);
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			
			System.out.println(buffer);
			
			buffer.delete(0, buffer.length());

		}
	}
	
	public static void main(String[] args) {
		new StringBufferMain().output();
		
		
	}
}
