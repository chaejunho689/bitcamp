<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Board.BoardDAO" %>
<%@ page import="Board.BoardDTO" %>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작전의 공백 제거 --%>
<%
    int board_no = Integer.parseInt(request.getParameter("board_no"));

    BoardDAO boardDAO = BoardDAO.getInstance();
    BoardDTO board = boardDAO.getBoardByNo(board_no);
    
    // 조회수 증가
    boardDAO.increaseHit(board_no);

    if (board != null) {
        String json = "{"
                + "\"board_no\": " + board.getBoard_no() + ","
                + "\"board_title\": \"" + board.getBoard_title() + "\","
                + "\"board_author\": \"" + board.getBoard_author() + "\","
                + "\"board_content\": \"" + board.getBoard_content() + "\","
                + "\"board_hit\": \"" + board.getBoard_hit() + "\","
                + "\"board_date\": \"" + board.getBoard_date() + "\""
                + "}";
        out.print(json);
    } else {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        out.print("{\"error\": \"게시글을 찾을 수 없습니다.\"}");
    }
%>