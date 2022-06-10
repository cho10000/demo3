
<%@ page contentType="text/plain; charset=UTF-8" %>
<%@ page import="board.*" %>
<%@ page import="org.json.simple.*" %>

<%
BoardDAO boardDAO = new BoardDAO();

int b_no = Integer.parseInt(request.getParameter("b_no"));

BoardVO boardVO = boardDAO.read(b_no);
JSONObject json = new JSONObject();

json.put("b_no", boardVO.getB_no());
json.put("b_type", boardVO.getB_type());
json.put("b_title", boardVO.getB_title());
json.put("b_content", boardVO.getB_content());
json.put("b_file", boardVO.getB_file());
json.put("b_user", boardVO.getB_user());

out.println(json);
%>
