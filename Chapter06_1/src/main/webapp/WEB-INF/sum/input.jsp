<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form method="get" action="http://localhost:8080/Chapter06_1/result.do">
        <table>
            <tr>
                <td>x :</td>
                <td><input type="text" name="x"></td>
            </tr>
            <tr>
                <td>y :</td>
                <td><input type="text" name="y"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="계산"></td>
                <td colspan="2"><input type="reset" value="취소"></td>
            </tr>
        </table>
    </form>
</body>
</html>