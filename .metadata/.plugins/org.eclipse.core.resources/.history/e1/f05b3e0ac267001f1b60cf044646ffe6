<%@page import="Board.BoardDTO"%>
<%@page import="Board.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작전의 공백 제거 --%>
<%@ page language="java" contentType="application/json; charset=UTF-8" %>
<%
    BoardDAO dao = BoardDAO.getInstance();
    List<BoardDTO> boardList = dao.getBoardList();
    
    StringBuilder json = new StringBuilder("[");
    for (int i = 0; i < boardList.size(); i++) {
        BoardDTO board = boardList.get(i);
        json.append("{")
            .append("\"board_no\":").append(board.getBoard_no()).append(",")
            .append("\"board_title\":\"").append(board.getBoard_title()).append("\",")
            .append("\"board_author\":\"").append(board.getBoard_author()).append("\",")
            .append("\"board_content\":\"").append(board.getBoard_content()).append("\",")
            .append("\"board_hit\":\"").append(board.getBoard_hit()).append("\",")
            .append("\"board_date\":\"").append(board.getBoard_date()).append("\"")
            .append("}");
        
        if (i < boardList.size() - 1) {
            json.append(",");
        }
    }
    json.append("]");
    
    out.print(json.toString());
%>