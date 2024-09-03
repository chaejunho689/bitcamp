<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//JAVA
//keyword로 넘어온 값을 내놔라 (서버가 받음)
String result = request.getParameter("keyword");

%>

<!-- request로 받은 result값을 출력하라  -->
결과(jsp) = <%=result %> 
<br>
결과(EL/JSTL) = ${param.keyword}

<%-- sjp주석 --%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	html
	<pre>
		jsp : java + html 
		contentType="text/html; => 지금부터 쓰틑 코드는 전부 html로 인식하겠다
		<% %> : 페이지 디렉티브
	</pre>
	
	<pre>
		EL / JSTL
			${param.keyword} 
		
		jsp
			request.getParameter("keyword");
		
		
		위에 두개가 같음. 
		
		공부 순서 : jsp >> EL/JSTL  >> Spring
	</pre>
</body>
</html>