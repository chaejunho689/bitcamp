<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="result" value="true" />
<c:set var="message" value="안녕하세요 홍길동님" />

<c:if test="${param.user_id != 'hong' }">
	<c:set var="result" value="false" />
	<c:set var="message" value="가입되지 않은 아이디입니다." />
</c:if>

<c:if test="${param.user_password != '111' }">
	<c:set var="result" value="false" />
	<c:set var="message" value="비밀번호가 틀렸습니다." />
</c:if>

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<login>
	<result>${result }</result>
	<message>${message }</message>
</login>




