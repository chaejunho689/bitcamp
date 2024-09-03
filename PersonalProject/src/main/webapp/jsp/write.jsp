<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Board.BoardDAO" %>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작전의 공백 제거 --%>
<%
	// GET 파라미터로 전달된 값들을 받아옵니다.
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String author = request.getParameter("author");
	
    // null 값 확인
    if (author == null || author.trim().isEmpty()) {
        out.print("작성자 값이 없습니다.");
        return; // 더 이상 처리하지 않음
    }
    
	// BoardDAO를 사용하여 게시글을 저장합니다.
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.writePost(title, content, author);
	
	// 성공적으로 작성되었음을 알려주는 메시지
	response.setContentType("text/html; charset=UTF-8");
%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="3;url=contact.html">
    <title>게시글 작성 완료</title>
    <style>
        .timer {
            font-size: 24px;
            font-weight: bold;
            color: #FF0000;
        }
    </style>
    <script>
        let seconds = 3;
        function updateTimer() {
            document.getElementById("timer").innerHTML = seconds + "초 후에 목록으로 이동합니다.";
            seconds--;
            if (seconds < 0) {
                window.location.href = "../contact.html";
            } else {
                setTimeout(updateTimer, 1000);
            }
        }
        window.onload = updateTimer;
    </script>
</head>
<body>
    <h2>게시글이 작성되었습니다.</h2>
    <p class="timer" id="timer"></p>
</body>
</html>