<%@page import="silver.web.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
  <meta charset="UTF-8">
  
  <link rel="stylesheet" href="css/public.css"/>
  <title>Web Project</title>
 
 </head>
 <body>
  
  
		<div id="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>

		<div id="container">
			<jsp:include page="login.jsp"></jsp:include>
		</div>

		<div id="bottom">
			<address>Copyright Seven Stars &copy; allright inc.</address>
		</div>
 

 </body>
</html>
