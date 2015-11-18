<%@page import="silver.web.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%
	LoginVO login = (LoginVO)session.getAttribute("login_ok");
%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>은빛마을</title>
<link rel="stylesheet" href="css/public.css" type="text/css" />
<style type="text/css">
	#masterList{position:relative; width:600px; height:auto; margin:0 auto; margin-top:255px;}
</style>
</head>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../masterPage_navi.jsp"></jsp:include>

<body topmargin=0 leftmargin=0 marginwidth="0" marginheight="0">
<input type="hidden" name="nowPage"/>
<!--주요내용시작 -->
<form name="ff2" method="post" action="m_list.sc" id="masterList">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td valign="top">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td align="center" height="10"></td>
		</tr>
		<tr>
		  <td align="center"><u><b>회원목록</b></u></td>
		</tr>
		<tr>
		  <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			</table>
			<table width="700" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td height="2" bgcolor="#C3C3C3"></td>
			  </tr>
			  <tr>
<!-- 			  tel, name, birth, addr, gender, status,
	date, pwd, idx, nickname; -->
				<td bgcolor="#E5E5E5">
				<table width="100%" border="0" cellspacing="1" cellpadding="2">
					<tr>
					  <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">번호</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="56"><font color="#FFFFFF">전화번호</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="270"><font color="#FFFFFF">이름</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="80"><font color="#FFFFFF">생일</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="300"><font color="#FFFFFF">가입날짜</font></td>
					   <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">주소</font></td>
					    <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">성별</font></td>
					    <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">상태</font></td>
					    <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">삭제</font></td>
					</tr>
       <c:forEach var="vo" items="${list }" varStatus="stat">
					<tr>
					  <td bgcolor="#F2F7F9">
                         
						${rowTotal-((nowPage-1)*blockList+stat.index) }
                      </td>
					  <td bgcolor="#F2F7F9" style="text-align:left">
					  	
					 	<a href="masedit.sc?idx=${vo.idx }&nowPage=${nowPage}"> 
							${vo.tel }
						</a>
                      </td>
					  <td bgcolor="#F2F7F9">${vo.name}</td>
					  <td bgcolor="#F2F7F9">${vo.birth }</td>
					  <td bgcolor="#F2F7F9">${vo.date }</td>
					  <td bgcolor="#F2F7F9">${vo.addr }</td>
					  <td bgcolor="#F2F7F9">${vo.gender}</td>
					    <td bgcolor="#F2F7F9">${vo.status}</td>
					    <td> <a href="masdel.sc?idx=${vo.idx }&nowPage=${nowPage}"><img src="images/button/but_del.gif" width="56" height="21">
                 </a>
                   </td>
					</tr>
       </c:forEach>
       <c:if test="${empty list }">
				<tr>
				  <td bgcolor="#F2F7F9" colspan="5" height="70" align="center">등록된 회원 없음!!.</td>
				</tr>
       </c:if>
				  </table></td>
			  </tr>
			</table>
			<table width="700" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td height="20" valign="middle"><img src="/img/sub_it/point_line.gif" width="700" height="3"></td>
			  </tr>
			  <tr>
				<td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					  <td width="315" align="left">
                          ${pageCode }
					 </td>					
					</tr>
				  </table></td>
			  </tr>
			</table></td>
		</tr>
		<tr>
		  <td height="19">&nbsp;</td>
		</tr>
	  </table>
	</td>
  </tr>
</table>
</form>

 <!--주요내용끝 -->

</body>
</html>