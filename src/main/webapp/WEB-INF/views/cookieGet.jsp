<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>��Ű Ȯ�� ������</h1>
	<%
		request.setCharacterEncoding("utf-8");
		// ��Ű ������ ���
		Cookie[] cookies = request.getCookies();
		// ��Ű�� ���� �ִٸ�
		for(int i = 0; i<cookies.length; i++){
			String name = cookies[i].getName(); // ��Ű �̸�
			String value = cookies[i].getValue(); // ��Ű ��
			if(name.equals("abc")){
				out.println("cokies[" + i + "] name : " + name);
				out.println("<br/>");
				out.println("cokies[" + i + "] value : " + value);
			}
		}
	%>
	<br><br>
	<a href="cookieDel.jsp">��Ű�� ���� �������� �̵�</a>
</body>
</html>