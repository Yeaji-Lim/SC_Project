<%-- 
    Document   : view
    Created on : 2009. 4. 3, 오후 12:21:38
    Author     : hb00
--%>

<%@page import="silver.web.board.vo.NoticeBoardVO"%>
<%@page import="silver.web.member.vo.LoginVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
	#notiView{
		position:relative; width:600px; height:auto; margin:0 auto; margin-top:255px;
	}
</style>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="text.css" rel="stylesheet" type="text/css">

</head>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../navi.jsp"></jsp:include>

<body>
<table width="556" border="0" cellspacing="0" cellpadding="0" align="center" id="notiView">
		  <tr>
		    <td align="center"><u><b>공지사항</b><u></td>
		  </tr>
		  <tr>
			<td height="2" bgcolor="#C3C3C3"></td>
		  </tr>
		  <tr>
			<td valign="top" bgcolor="#E5E5E5">

			<table width="100%" border="0" cellspacing="1" cellpadding="3">
				<tr>
				  <td width="80" height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">글쓴이</font></td>
                  <td bgcolor="#F2F7F9">${vo.nickname}</td>
				  <td width="80" align="center" bgcolor="#669AB3"><font color="#FFFFFF">등록일</font></td>
				  <td width="150" align="center" bgcolor="#F2F7F9">${vo.write_date}</td>
				</tr>
				<tr>
				  <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">제목</font></td>
				  <td colspan="3" bgcolor="#F2F7F9">${vo.subject}</td>
				</tr>
				<tr valign="top">
				  <td height="23" colspan="4" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellspacing="0" cellpadding="15">
					  <tr>
						<td valign="top"> <pre>${vo.content}</pre>
						  <p>&nbsp;</p></td>
					  </tr>
					</table></td>
				</tr>
			  </table>
			</td>
		  </tr>
		</table>
		<table width="556" border="0" cellspacing="0" cellpadding="0" align="center">
		  <tr>
			<td height="20" valign="middle"><img src="/img/sub_it/point_line.gif" width="556" height="3"></td>
		  </tr>
		  <tr>
			<td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
				  <td align="left">
					&nbsp;
				  </td>
				  <td width="241" align="right">
				  	<c:if test="${vo.nickname eq nickname.nickname }">
				   	<img src="images/button/but_modify.gif" width="56" height="21" onClick="javascript:location.href='notice_edit.sc?b_idx=${seq}&nowPage=${nowPage }'" style="cursor:pointer">
					</c:if>
					<img src="images/button/but_list.gif" width="56" height="21" onClick="JavaScript:location.href='notice.sc?nowPage=${nowPage}'" style="cursor:pointer">
					<c:if test="${vo.nickname eq nickname.nickname}">
					<img src="images/button/but_undel.gif" width="56" height="21" onClick="javaScript:location.href='notice_del.sc?b_idx=${seq}&nickname=${nickname.nickname }'" }>
					</c:if>
					</td>
				</tr>
			  </table></td>
		  </tr>
		  <tr>
			<td height="19">&nbsp;</td>
		  </tr>

			  

		</table>
		<iframe id="check_f" border='0' width="0" height="0" frameborder='0' marginwidth='0' marginheight='0' scrolling="no"></iframe>
		</td>
	</tr>
	<tr>
	  <td height="19">&nbsp;</td>
	</tr>
  </table>
  </body>
  </html>
