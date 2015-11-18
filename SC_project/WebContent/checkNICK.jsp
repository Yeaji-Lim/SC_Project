<%@page import="silver.web.member.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>    
<%boolean check = (boolean)session.getAttribute("check"); %>

	<%if(check){ %>
	<span class="success">사용가능</span>
	<%}else{ %>
	<span class="fail">사용불가</span>	
	<%}%>