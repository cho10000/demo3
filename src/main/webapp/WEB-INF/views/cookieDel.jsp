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
	
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i<cookies.length; i++){
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			if(name.equals("abc")){
				out.println("cokies[" + i + "] name : " + name);
				out.println("<br/>");
				out.println("cokies[" + i + "] value : " + value);
				// ��ȿ�ð��� 0�� ���� �����ϴ� ȿ��
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				out.println("cokies[" + i + "] name : " + name);
				out.println("<br/>");
				out.println("cokies[" + i + "] value : " + value);
			}
		}
	%>
	<br><br>
	<a href="/checkcook">��Ű�� Ȯ�� �������� �̵�</a>
</body>
</html>