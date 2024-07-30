package board.service;

import board.dao.BoardDAO;

public class BoardLogoutService implements Board {
	@Override
	public void execute() {
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.logout();
	}
}
