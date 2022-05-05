<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 확인 페이지</h1>
	<%
		request.setCharacterEncoding("utf-8");
		// 쿠키 정보를 얻기
		Cookie[] cookies = request.getCookies();
		// 쿠키에 값이 있다면
		for(int i = 0; i<cookies.length; i++){
			String name = cookies[i].getName(); // 쿠키 이름
			String value = cookies[i].getValue(); // 쿠키 값
			if(name.equals("abc")){
				out.println("cokies[" + i + "] name : " + name);
				out.println("<br/>");
				out.println("cokies[" + i + "] value : " + value);
			}
		}
	%>
	<br><br>
	<a href="cookieDel.jsp">쿠키값 삭제 페이지로 이동</a>
</body>
</html>