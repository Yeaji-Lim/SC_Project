<%-- 
    Document   : view
    Created on : 2009. 4. 3, 오후 12:21:38
    Author     : hb00
--%>
<%@page import="silver.web.member.vo.LoginVO"%>
<%@page import="silver.web.board.vo.BbsVO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% BbsVO vo = (BbsVO)request.getAttribute("vo");


	LoginVO login = (LoginVO)session.getAttribute("login_ok");
%>

<link href="text.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	function download(fname){
	
		location.href="FileDownload?dir=upload&filename="+fname;
		//위의 FileDownload는 서블릿이다.
	}
	
	function addAns(ff) {
		
		var content = document.f.content.value;
		if(content==""){
			alert("내용입력해");
			return;
		}
		
		ff.submit();
		
	}
	
</script>
</head>

<body>

<table width="556" border="0" cellspacing="0" cellpadding="0" align="center">


		  <tr>
		    <td align="center"><u><b>BBS 내용보기</b><u></td>
		  </tr>
		  <tr>
			<td height="2" bgcolor="#C3C3C3"></td>
		  </tr>
		  <tr>
			<td valign="top" bgcolor="#E5E5E5">

			<table width="100%" border="0" cellspacing="1" cellpadding="3">
				<tr>
				  <td width="80" height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">글쓴이</font></td>
                  <td bgcolor="#F2F7F9">${vo.writer}</td>
				  <td width="80" align="center" bgcolor="#669AB3"><font color="#FFFFFF">등록일</font></td>
				  <td width="150" align="center" bgcolor="#F2F7F9">${vo.regdate}</td>
				</tr>
				<tr>
				  <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">메일</font></td>
				  <td bgcolor="#F2F7F9"></td>
				  <td align="center" bgcolor="#669AB3"><font color="#FFFFFF">조회수</font></td>
				  <td align="center" bgcolor="#F2F7F9">${vo.hit}</td>
				</tr>
				<tr>
				  <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">첨부파일</font></td>
				  <td colspan="3" bgcolor="#F2F7F9">
				  <a href="javascript:download('${vo.uploadFileName}')">
				  	${vo.uploadFileName}
				  </a>
				  </td>
				</tr>
				<tr>
				  <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">제목</font></td>
				  <td colspan="3" bgcolor="#F2F7F9">${vo.title}</td>
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
			<td height="20" valign="middle"><img src="/images/sub_it/point_line.gif" width="556" height="3"></td>
		  </tr>
		  <tr>
			<td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
				  <td align="left">
					&nbsp;
				  </td>
				  
				  <%if(login == null){
				%>	  <img src="images/button/but_list.gif" width="56" height="21" onClick="JavaScript:location.href='info.sc?nowPage=${nowPage }'" style="cursor:pointer"/>
				  <% }
					  %>
				  
				  
				  <%if(login != null){ %>
				  
				  <td width="241" align="right"><img src="images/button/but_answer.gif" width="56" height="21" onClick="JavaScript:location.href='answer.sc?seq=${seq}&groups=${vo.groups }&step=${vo.step }&lev=${vo.lev }&nowPage=${nowPage }'" style="cursor:pointer">
					
					<%if(login.getName().equals(vo.getWriter())){%>
					<img src="images/button/but_modify.gif" width="56"
					height="21" onClick="javascript:location.href='edit.sc?seq=${seq}&nowPage=${nowPage }'" style="cursor:pointer">
					<%}%>
					<img src="images/button/but_list.gif" width="56" height="21" onClick="JavaScript:location.href='info.sc?nowPage=${nowPage }'" style="cursor:pointer">
					
			
					
					

					<%if(login.getName().equals(vo.getWriter())){ %>
					<img src="images/button/but_undel.gif" width="56" height="21"
					onclick="javascript:location.href='del.sc?seq=${seq}'">
					<%}%>
					<%}%>
					</td>
				</tr>
			  </table></td>
		  </tr>
		  <tr>
			<td height="19">&nbsp;</td>
		  </tr>
	</table>
	

		  
	<h2>댓글들</h2>
	<hr/>
	<c:forEach items="${svo }" var="cvo" varStatus="i">
		<c:if test="${svo }==null">
		댓글없음
		</c:if>	
	이름:${cvo.getWriter()}&nbsp;&nbsp;&nbsp;날짜:${ cvo.getWrite_date() }<br/>
	내용:${ cvo.getContent() }
	  	
	<%if(login!=null ){%>
	
		<div>
			
			<%if(login.getName().equals(vo.getWriter())){ %>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="댓글삭제"
			onclick="javascript:location.href='delComm.sc?c_idx=${cvo.getC_idx() }&seq=${seq}&nowPage=${nowPage }'"/>
			<% }}%>
			<hr/>
		</div>
	</c:forEach>

	
	
	
		<%if(login != null){ %>
		<h2>댓글쓰기</h2>
		<form name="f" action="comment.sc" method="post">
		이름:<input type="text" value="${login_ok.name }"name="writer" readonly="readonly"/><br/>
		내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
		<input value="1" type="hidden" name="pwd"/>
		&nbsp;&nbsp;
		<input type="hidden" name="seq" value="${vo.seq }"/>
		<input type="hidden" name="nowPage" value="${nowPage }"/>
		<input type="button" value="댓글달기" onclick="addAns(this.form)"/>
		<%}%>
	</form>
	<br/>


  </body>
  </html>
