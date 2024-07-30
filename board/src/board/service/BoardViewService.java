package board.service;

import java.util.Scanner;

import board.dao.BoardDAO;

public class BoardViewService implements Board{

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		System.out.println("글 번호를 입력하세요.");
		int num = scan.nextInt();
		
		boardDAO.boardView(num);
	}
	
}
