<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 설정 페이지</h1>
	<%
		request.setCharacterEncoding("utf-8");
		// 쿠키 지정 name, value
		Cookie cookie = new Cookie("abc", "123");
		// 쿠키의 유효시간 설정
		cookie.setMaxAge(60*60);
		// 쿠키 추가
		response.addCookie(cookie);
	%>
	<br><br>
	<a href="cookieGet.jsp">쿠키값 확인창으로 이동</a>
</body>
</html>