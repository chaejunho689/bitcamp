package board.main;

import java.util.Scanner;

import board.service.Board;
import board.service.BoardListService;
import board.service.BoardLoginService;
import board.service.BoardLogoutService;
import board.service.BoardRegistService;
import board.service.BoardViewService;
import board.service.BoardWriteService;

public class IndexMain {

	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num;
		Board board = null;
		
		while(true) {
			System.out.println();
			System.out.println("***********************");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 글쓰기 ");
			System.out.println("4. 목록 ");
			System.out.println("5. 작성한 글 내용 보기 ");
			System.out.println("6. 로그아웃 ");
			System.out.println("7. 프로그램 종료 ");
			System.out.println("***********************");
			System.out.print(" 번호 :");
			num = scan.nextInt();
			
			if(num == 7) break;
			if(num == 1) {
				board = new BoardRegistService();
			} else if(num == 2) {
				board = new BoardLoginService();
			} else if(num == 3) {
				board = new BoardWriteService();
			} else if(num == 4) {
				board = new BoardListService();
			} else if(num == 5) {
				board = new BoardViewService();
			} else if(num == 6) {
				board = new BoardLogoutService();
			}
			
			board.execute();
		}
	}
	
	public static void main(String[] args) {
		IndexMain indexMain = new IndexMain();
		indexMain.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
