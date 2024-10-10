<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
총점 : ${param.kor + param.eng + param.mat}
<br>
평균 : ${param.kor + param.eng + param.mat / 3}

<br>
<br>

이름 : ${param.name}
총점 : ${param.tot}
<br>
평균 : <fmt:formatNumber pattern="#.##" value="${param.avg}" />



</h3>
</body>
</html>