<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form method="post" action="http://localhost:8080/Chapter06_1/sungjuk/result.do">
        <table>
            <tr>
                <td>이름 :</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>국어 :</td>
                <td><input type="number" name="kor"></td>
                <td>영어 :</td>
                <td><input type="number" name="eng"></td>
                <td>수학 :</td>
                <td><input type="number" name="mat"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="제출"></td>
                <td colspan="2"><input type="reset" value="취소"></td>
            </tr>
        </table>
    </form>
</body>
</html>