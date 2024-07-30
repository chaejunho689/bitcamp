package board.service;

import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardRegistService implements Board{

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = scan.next();
			
			//DB
			boolean exist = boardDAO.isExistId(id);
			
			if(exist == true) {
				System.out.println("중복된 ID입니다.");
				return;
			} else {
				System.out.println("사용 가능한 아이디입니다.");
				

				System.out.println("비밀번호를 입력하세요.");
				String pwd = scan.next();
		
				System.out.println("이름을 입력하세요.");
				String name = scan.next();
				
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setName(name);
				boardDTO.setId(id);
				boardDTO.setPwd(pwd);
				//입력
				boardDAO.register(boardDTO);
				break;
			}
		}

	}
	

}
