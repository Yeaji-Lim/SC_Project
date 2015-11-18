<%-- 
    Document   : view
    Created on : 2009. 4. 3, 오후 12:21:38
    Author     : hb00
--%>

<%@page import="silver.web.board.vo.FreeBoardVO"%>
<%@page import="silver.web.member.vo.LoginVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>은빛마을</title>
<link rel="stylesheet" href="css/public.css" type="text/css" />
<style type="text/css">
	div#del_win{
		position: absolute;
		top: 150px;
		left: 200px;
		width: 160px;
		height: 70px;
		background-color: #ffffff;
		padding-top: 10px;
		border-radius: 10px;
		border: 1px solid black;
		text-align: center;
		display: none; /* 안보이도록 함! */
	}
	
	#frView{position:relative; width:600px; height:auto; margin:0 auto; margin-top:255px;}
</style>
<script type="text/javascript">

function openDel(){

	// 삭제를 하기 위해 비밀번호를
	// 물어보는 div를 보여준다.
	document.getElementById("del_win").style.display = "block";
	
	
}
function del_bbs(){
	//사용자가 입력한 비밀번호 가져오기
	var fb_pwd = 
	  document.getElementById("fb_pwd").value;
	
	if(fb_pwd == "")
		return;
	
	//현재 영역을 수행한다면 위의 return문을
	//만나지 않았다는 뜻이며, 이는
	// 사용자가 비번을 입력한 경우다.
	//이때
	// 현재문서(document)에 myForm이라는 곳에
	// 이름이 pwd라는 요소의 값(value)으로
	// pw의 값을 지정한다.
	document.freedel.fb_pwd.value = fb_pwd;
	//document.freedel.action="freedel.sc";

	
	document.freedel.submit();//자원 보내기
}
function cc(){
	var d_win = document.getElementById(
		"del_win");

	d_win.style.display = "none";
}



</script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="text.css" rel="stylesheet" type="text/css">

</head>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../board_navi.jsp"></jsp:include>
<%
LoginVO login = (LoginVO)session.getAttribute("login_ok");

FreeBoardVO free = (FreeBoardVO)session.getAttribute("free");
%>
<body>
<table width="556" border="0" cellspacing="0" cellpadding="0" align="center" id="frView">
		  <tr>
		    <td align="center"><b>자유게시판 글보기</b></td>
		  </tr>
		  <tr>
			<td height="2" bgcolor="#C3C3C3"></td>
		  </tr>
		  <tr>
			<td valign="top" bgcolor="#E5E5E5">

			<table width="100%" border="0" cellspacing="1" cellpadding="3">
				<tr>
				  <td width="80" height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">글쓴이</font></td>
                  <td bgcolor="#F2F7F9">${vo.fb_writertel}</td>
				  <td width="80" align="center" bgcolor="#669AB3"><font color="#FFFFFF">등록일</font></td>
				  <td width="150" align="center" bgcolor="#F2F7F9">${vo.fb_regdate}</td>
				</tr>
				<tr>
				  <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">메일</font></td>
				  <td bgcolor="#F2F7F9"></td>
				  <td align="center" bgcolor="#669AB3"><font color="#FFFFFF">조회수</font></td>
				  <td align="center" bgcolor="#F2F7F9">${vo.fb_readcount}</td>
				</tr>
				<tr>
				  <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">제목</font></td>
				  <td colspan="3" bgcolor="#F2F7F9">${vo.fb_subject}</td>
				</tr>
				<tr valign="top">
				  <td height="23" colspan="4" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellspacing="0" cellpadding="15">
					  <tr>
						<td valign="top"> <pre>${vo.fb_content}</pre>
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
			<td height="20" valign="middle"><img src="/images/sub_it/point_line.gif" width="556" height="3"></td>
		  </tr>
		  <tr>
			<td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
				  <td align="left">
					&nbsp;
				  </td>
				  
				  <td width="241" align="right">
				  <%if(login == null){ %>
				  <img src="images/button/but_list.gif" width="56" height="21" onClick="javaScript:location.href='freelist.sc?nowPage=${nowPage}'" style="cursor:pointer">
				  <%} %>
				  <%if(login != null && login.getName().equals(free.getFb_writertel())){ %>
					<img src="images/button/but_modify.gif" width="56" height="21" onClick="javascript:location.href='freeedit.sc?fb_num=${fb_num}&nowPage=${nowPage }'" style="cursor:pointer">
					<img src="images/button/but_list.gif" width="56" height="21" onClick="JavaScript:location.href='freelist.sc?nowPage=${nowPage}'" style="cursor:pointer">

					<img src="images/button/but_del.gif" width="56" height="21" onclick="openDel()"/>
				<%} %>
					</td>
				</tr>
			  </table></td>
			  		<%--댓글들</hr>
		 <c:forEach items="${list1 }" var="list">
		<div>
			이름:${list.fb_r_write } &nbsp;&nbsp;
			날짜:${list.fb_r_regdate }<br/>
			내용:${list.fb_r_content }
		</div>
</c:forEach> --%>
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
  	<div id="del_win">
	
		비밀번호:<input type="password" 
		id="fb_pwd" size="7"/>
		<input type="button" value="삭제" 
		 onclick="del_bbs()"/>
		<input type="button" value="취소" 
		 onclick="cc()"/>

	</div>
	
<%-- 삭제 또는 수정시를 위한 폼 --%>
	<form name="freedel" method="post" action="freedel.sc">
		<input type="hidden" name="fb_num" 
		 value="${vo.fb_num }"/>
		<input type="hidden" name="nowPage" 
		 value="${nowPage }"/>
		 <
		 
		<%-- del_win에서 입력받은 비밀번호를
		 다음 아래의 요소에 대입한다. --%>
		<input type="hidden" name="fb_pwd"/>
		
	</form>
  
  
  </body>
  </html>
