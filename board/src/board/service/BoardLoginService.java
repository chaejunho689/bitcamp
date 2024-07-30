package board.service;

import java.util.Scanner;

import board.dao.BoardDAO;

public class BoardLoginService implements Board {
	
	@Override
	public void execute() {

		Scanner scan = new Scanner(System.in);
		// DB - 싱글톤 
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = scan.next();
			
			System.out.println("비밀번호를 입력하세요.");
			String pwd = scan.next();

			boolean id_check = boardDAO.isExistId(id);
			if(id_check == false) {
				System.out.println("아이디 또는 비밀번호가 잘못되었습니다..");
			} else {
				boardDAO.login(id, pwd);
				boardDAO.login_check();
				String sessionName = boardDAO.session_name;
				System.out.println(sessionName+ "님이 로그인하였습니다.");
				break;
			}
		}
	}

}
