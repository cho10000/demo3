<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 재확인 페이지</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0; i<cookies.length; i++){
				out.println(cookies[i].getName());
				out.println(cookies[i].getValue());
			}
		}
	%>
</body>
</html>