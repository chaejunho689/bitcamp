<%@page import="Account.AccountDTO"%>
<%@page import="Account.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작전의 공백 제거 --%>
<%

	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String user_name = request.getParameter("user_name");
	String user_email = request.getParameter("user_email");
	String user_address = request.getParameter("user_address");
	String user_phonenumber = request.getParameter("user_phonenumber");
	String result = "";
	
	AccountDAO accountDAO = new AccountDAO();
	
	accountDAO.register(user_id, user_pw, user_name, user_email, user_address, user_phonenumber);
%>
<%=result %>