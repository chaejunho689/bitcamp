<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%!
	// 전역 변수
// 	int num = 3;
%>
<%
	// JAVA
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String num = request.getParameter("num");
	String datetime = request.getParameter("datetime");

// 	num++; // 4
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
// 	String datetime = sdf.format(date);
	
	boolean result = true;
	String message = "댓글이 작성되었습니다.";
	
%>
<?xml version="1.0" encoding="UTF-8"?>
<comment>
	<result><%=result%></result>
	<message><%=message%></message>
	<item>
		<num><%=num%></num>
		<writer><%=writer%></writer>
		<content><%=content%></content>
		<datetime><%=datetime%></datetime>
	</item>
</comment>