<%@page import="Account.AccountDTO"%>
<%@page import="Account.AccountDAO"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작전의 공백 제거 --%>
<%

String login_id = request.getParameter("login_id");
String login_pw = request.getParameter("login_pw");

// AccountDAO 인스턴스 생성
AccountDAO accountDAO = new AccountDAO();

// 로그인 처리
String loginResult = accountDAO.login(login_id, login_pw);

// 로그 출력
System.out.println("로그인 시도: ID=" + login_id + ", PW=" + login_pw + ", 결과=" + loginResult);

// 로그인 성공 여부를 판단하여 JSON 형식으로 응답
response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");

if ("success".equals(loginResult)) {
    AccountDTO account = accountDAO.getAccountById(login_id);
    if (account != null) {
        String userId = account.getUser_id();

        // 쿠키 설정
        Cookie userIdCookie = new Cookie("userId", userId);
        userIdCookie.setMaxAge(60*60*24); // 1일 동안 유효
        userIdCookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
        response.addCookie(userIdCookie);

        // JSON 응답 생성
        response.getWriter().write("{\"status\": \"success\", \"userId\": \"" + userId + "\"}");
    } else {
        // 로그인 실패 응답
        response.getWriter().write("{\"status\": \"fail\"}");
    }
} else {
    // 로그인 실패 응답
    response.getWriter().write("{\"status\": \"fail\"}");
}
%>