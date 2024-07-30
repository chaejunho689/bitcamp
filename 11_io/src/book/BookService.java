package book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
	private ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	
	public void menu() throws ClassNotFoundException, IOException {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		Book com = null;
		
		while(true) {
			System.out.println("\n\t\t메뉴");
			System.out.println("**********************************");
			System.out.println("1. 등록 : ");
			System.out.println("2. 출력 : ");
			System.out.println("3. 파일 저장 : ");
			System.out.println("4. 파일 읽기 : ");
			System.out.println("5. 책 제목으로 오름차순 : ");
			System.out.println("6. 책 제목 검색 : ");
			System.out.println("7. 프로그램 종료 : ");
			System.out.println("**********************************");
			System.out.println("번호 : ");
			num = scan.nextInt();
			
			
			if(num == 7) break;
			if(num == 1) {
				com = new BookInsert(); // 책 입력
			} else if (num == 2) {
				com = new BookPrint();
			} else if (num == 3) {
				com = new BookFileWrite();
			}  else if (num == 4) {
				com = new BookFileRead();
			}  else if (num == 5) {
				com = new BookTitleAsc();
			} else if (num == 6) {
				com = new BookTitleSearch();
			} else {
				System.out.println("1~6번 중에 선택하세요.");
				continue;
			}
				
			com.execute(list);
		}
	}

}
