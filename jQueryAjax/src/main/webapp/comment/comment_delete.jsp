<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	String num = request.getParameter("num");

	//고유한 값인 num(key)로 DB에서 삭제한다.
	boolean result = true;
	String message = "댓글이 삭제 되었습니다.";
%>

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<comment>
	<result><%=result%></result>
	<message><%=message%></message>
</comment>