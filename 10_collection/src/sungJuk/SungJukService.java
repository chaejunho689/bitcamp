package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukService {
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		SungJuk com = null;
				
		while(true) {
			System.out.println("\n\t\t메뉴");
			System.out.println("**********************************");
			System.out.println("\t1. 입력 : ");
			System.out.println("\t2. 출력 : ");
			System.out.println("\t3. 수정 : ");
			System.out.println("\t4. 삭제 : ");
			System.out.println("\t5. 정렬 : ");
			System.out.println("\t6. 끝 : ");
			System.out.println("**********************************");
			System.out.println("번호 : ");
			num = scan.nextInt();
			
			if(num == 6) break;
			if(num == 1) {
				com = new SungJukInsert(); //생성
			} else if (num == 2) {
				com = new SungJukPrint();
			} else if (num == 3) {
				com = new SungJukUpdate();
			}  else if (num == 4) {
				com = new SungJukDelete();
			}  else if (num == 5) {
				com = new SungJukSort();
			} else {
				System.out.println("1~6번 중에 선택하세요.");
				continue;
			}
				
			com.execute(list);
		}
	}
		

		
	
	// 성적 Update
	public void PersonUpdate() {
			
		}
	// 성적 Delete
	public void PersonDelete() {
		
	}
	// 성적 Sort
		
	public void PersonSort() {
		
	}	
}
