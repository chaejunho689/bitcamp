package board.service;

import board.dao.BoardDAO;

public class BoardListService implements Board{

	@Override
	public void execute() {
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		boardDAO.boardList();

		/*
		 ---------------------------------------------------------
		글번호	제목		아이디	날짜
		---------------------------------------------------------
		  5		과일		hong	2024.07.26
		  3		야채		hong	2024.07.26
		 */
	}
	
	
}
