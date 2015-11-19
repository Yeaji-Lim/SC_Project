<%@page import="silver.web.message.vo.MsgVO"%>
<%@page import="silver.web.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>은빛마을</title>
<link href="text.css" rel="stylesheet" type="text/css">

</head>
<body topmargin=0 leftmargin=0 marginwidth="0" marginheight="0">

<!--주요내용시작 -->
<form name="ff2" method="post">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td valign="top">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td align="center" height="10"></td>
		</tr>
		<tr>
		  <td align="center"><b>쪽지함</b></td>
		</tr>
		<tr>
		  <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			</table>
			<table width="556" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td height="2" bgcolor="#C3C3C3"></td>
			  </tr>
			  <tr>
				<td bgcolor="#E5E5E5">
				<table width="100%" border="0" cellspacing="1" cellpadding="2">
					<tr>
					  <td height="20" align="center" bgcolor="#669AB3" width="56"><font color="#FFFFFF">번호</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="270"><font color="#FFFFFF">제목</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="80"><font color="#FFFFFF">보낸이</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">날짜</font></td>
					</tr>
					
       				<c:forEach var="vo" items="${list }" varStatus="stat">
       				
					<tr>
					  <td bgcolor="#F2F7F9">
						${rowTotal-((nowPage-1)*blockList+stat.index) }
                      </td>
					  <td bgcolor="#F2F7F9" style="text-align:left">
					  	
					 	<a href="msg_view.sc?b_idx=${vo.b_idx }&nowPage=${nowPage}"> 
							${vo.subject }
						</a>
                      </td>
					  <td bgcolor="#F2F7F9">${vo.send_tel}</td>
					  <td bgcolor="#F2F7F9">${vo.write_date }</td>
					</tr>
      
       </c:forEach>
      
       <c:if test="${empty list }">
				<tr>
				  <td bgcolor="#F2F7F9" colspan="5" height="70" align="center">쪽지함이 비어있습니다.</td>
				</tr>
       </c:if>
				  </table></td>
			  </tr>
			</table>
			<table width="556" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td height="20" valign="middle"><img src="/img/sub_it/point_line.gif" width="556" height="3"></td>
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