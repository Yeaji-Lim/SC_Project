<%@page import="silver.web.member.vo.LoginVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>은빛마을</title>
<link rel="stylesheet" href="css/public.css" type="text/css" />

<style>
	#mbList{position:relative; width:600px; height:auto; margin:0 auto; margin-top:255px;}
	
</style>

<script type="text/javascript">
	function msg() {
		alert("로그인이 필요합니다!");
	}

</script>

</head>

<jsp:include page="../header.jsp"></jsp:include>
<body topmargin=0 leftmargin=0 marginwidth="0" marginheight="0">

<%
	request.setCharacterEncoding("utf-8");
	LoginVO login = (LoginVO)session.getAttribute("login_ok");
	
%> 

<!--주요내용시작 -->
<form name="ff2" method="post" id="mbList">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td valign="top">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td align="center" height="10"></td>
		</tr>
		<tr>
		  <td align="center"><b>요양사를 소개합니다</b></td>
		</tr>
		<tr>
		  <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			</table>
			<table width="600" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td height="2" bgcolor="#C3C3C3"></td>
			  </tr>
			  <tr>
				<td bgcolor="#E5E5E5">
				<table width="100%" border="0" cellspacing="1" cellpadding="2">
					<tr>
					  <td height="20" align="center" bgcolor="#669AB3" width="56"><font color="#FFFFFF">번호</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="250"><font color="#FFFFFF">제목</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="80"><font color="#FFFFFF">글쓴이</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">날짜</font></td>
					  <td height="20" align="center" bgcolor="#669AB3" width="100"><font color="#FFFFFF">지역</font></td>
					</tr>
       				<c:forEach var="vo" items="${list }" varStatus="stat">
					<tr>
					  <td bgcolor="#F2F7F9">
<!--                           <s:property value="rowTotal-((nowPage-1)*blockList+#stat.index)"/> -->
						${rowTotal-((nowPage-1)*blockList+stat.index) }
                      </td>
					  <td bgcolor="#F2F7F9" style="text-align:left">
					  	
					  <%-- step값만큼 들여쓰기하는 반복문 --%>
					  	<%-- <c:forEach begin="1" end="${vo.qb_step }">
					  		<c:out value="&nbsp;&nbsp;" escapeXml="false"/>
					  	</c:forEach> --%>
					  	
					  <!-- 	step이 0이 아닌 경우엔 화살표 이미지 출력 -->
					  <%-- <c:if test="${vo.qb_step > 0 }">
					  		<img src="images/arrow.JPG"/>
					  	</c:if>   --%>
					  	
<!--                           <s:a href="%{viewURL}"> -->
<!--                               <s:property value="title"/> -->
<!--                           </s:a> -->
						<a href="mb_view.sc?mb_num=${vo.mb_num }&nowPage=${nowPage}"> 
							${vo.mb_subject }
						</a>
                      </td>
					  <td bgcolor="#F2F7F9">${vo.mb_writer }</td>
					  <td bgcolor="#F2F7F9">${vo.mb_regdate }</td>
					  <td bgcolor="#F2F7F9">${vo.mb_location }</td>
					</tr>
       </c:forEach>
       <c:if test="${empty list }">
				<tr>
				  <td bgcolor="#F2F7F9" colspan="5" height="70" align="center">등록된 게시물이 없습니다.</td>
				</tr>
       </c:if>
				  </table></td>
			  </tr>
			</table>
			<table width="600" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td height="20" valign="middle"><img src="/images/sub_it/point_line.gif" width="600" height="3"></td>
			  </tr>
			  <tr>
				<td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					  <td width="400" align="left">
                          ${pageCode }
					  </td>
					  
					  <%
					  	if(login != null){
					  %> 
					  <td width="241" align="right"> <img src="images/but_write.gif" width="56" height="21" style="cursor:pointer" onClick="javascript:location.href='mb_writeForm.sc'">
					  <input type="hidden" name="login" value="<%=login.getTel()%>"> 
					  </td>
					  <%}else{ %> 
					  <td width="241" align="right"> <img src="images/but_write.gif" width="56" height="21" style="cursor:pointer" onclick="msg()">
					  
					  <%} %>
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
