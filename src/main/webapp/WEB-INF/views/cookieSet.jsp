<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��Ű ���� ������</h1>
	<%
		request.setCharacterEncoding("utf-8");
		// ��Ű ���� name, value
		Cookie cookie = new Cookie("abc", "123");
		// ��Ű�� ��ȿ�ð� ����
		cookie.setMaxAge(60*60);
		// ��Ű �߰�
		response.addCookie(cookie);
	%>
	<br><br>
	<a href="cookieGet.jsp">��Ű�� Ȯ��â���� �̵�</a>
</body>
</html>