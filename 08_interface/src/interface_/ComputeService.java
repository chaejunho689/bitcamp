package interface_;

import java.util.Scanner;

public class ComputeService {
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		Compute com = null;
				
		while(true) {
			System.out.println("*****************");
			System.out.println("\t1. 합 : ");
			System.out.println("\t2. 차 : ");
			System.out.println("\t3. 곱 : ");
			System.out.println("\t4. 몫 : ");
			System.out.println("\t5. 끝 : ");
			System.out.println("*****************");
			System.out.println("번호 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			if(num == 1) {
				com = new Sum(); //생성
			} else if (num == 2) {
				com = new Sub();
			} else if (num == 3) {
				com = new Mul();
			}  else if (num == 4) {
				com = new Div();
			}
			com.execute();
		}
		
		
		
	}
}
