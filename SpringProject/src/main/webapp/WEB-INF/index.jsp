<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 메인화면 </h2>

<h3> 
	<p> <a href="http://localhost:8080/spring/user/writeForm"> 입력 </a> </p>
	<p> <a href="/spring/user/list"> 출력 </a> </p>
<!-- 	pg=1일때는  ?=1 생략 가능 -->
</h3>
</body>
</html>
<!-- 
DispatcherServlet
		↓
user.controller
UserController.java
		↓
DispatcherServlet
		↓
user(폴더)
writeForm.jsp
 -->

