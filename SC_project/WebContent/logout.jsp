<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//세션에서 로그인 시 저장한 속성을
	// 삭제한다.
	session.removeAttribute("login_ok");

	// 페이지 이동
	response.sendRedirect("/SC_project/index.jsp");
%>









