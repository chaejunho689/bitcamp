package board.service;

import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;


public class BoardWriteService implements Board{

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		BoardDAO boardDAO = BoardDAO.getInstance();

		// 로그인 여부 확인 
		if(boardDAO.login_check() == false)	return;
		
		String sessionId = boardDAO.session_id;
		String sessionName = boardDAO.session_name;
		
		System.out.println("제목을 입력하세요.");
		String subject = scan.next();
		
		System.out.println("내용을 입력하세요.");
		String content = scan.next();

		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(sessionId);
		boardDTO.setName(sessionName);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		// boadWrite 서비스 실행
		boardDAO.boardWrite(boardDTO);
	
		System.out.println("작성하신 글을 등록하였습니다.");
		
	}
}
