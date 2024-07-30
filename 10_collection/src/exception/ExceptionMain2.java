package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionMain2 {
	private int x, y;

	public void input() throws NumberFormatException, IOException {
		/*
		Scanner scan = new Scanner(System.in);

		System.out.println("x 인수 입력");
		x = scan.nextInt();

		System.out.println("y 승 입력");
		y = scan.nextInt();
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("x 인수 입력");
		x = Integer.parseInt(br.readLine());

		System.out.println("y 승 입력");
		y = Integer.parseInt(br.readLine());
	}


	public void output() {
		int result = 1;

		if(y >= 0) {
			for(int i = 0; i < y; i++) {
				result = result * x;
			}
		} else {
//			System.out.println("y는 0보다 크거나 같아야합니다.");
			try {
				throw new Exception("y는 0보다 크거나 같아야합니다."); //에러메시지 발생
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		System.out.println(x + "의 " + y + "승은 " + result +" 입니다.");
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		ExceptionMain2 em = new ExceptionMain2();

		em.input();
		em.output();

	}
}
