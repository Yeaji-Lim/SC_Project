
<%@page import="silver.web.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 글쓰기</title>
<script type="text/javascript">
function check(ff){
	
	var title = document.forms[0].title.value;
	var content = document.forms[0].content.value;
	
	if(title==""){
		alert("제목입력해");
		return;
	}
	if(content==""){
		alert("내용입력해");
		return;
	}
	
	ff.submit();
}
</script>
<style type="text/css">
	#qbWrite{
		position:relative; width:600px; height:auto; margin:0 auto; margin-top:260px;
	}
</style>
</head>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../board_navi.jsp"></jsp:include>
<body>
<%
	LoginVO login = (LoginVO)session.getAttribute("login_ok");
%>
	<form action="qb_write.sc" method="post" id="qbWrite">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" height="10"></td>
        </tr>
        <tr>
          <td align="center"><u><b>문의사항 글쓰기</b></u></td>
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
                <td bgcolor="#E5E5E5"><table width="100%" border="0" cellspacing="1" cellpadding="2">

                    <tr>
                      <td width="90" height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">작성자</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="qb_writer" cssStyle="width:100px" 
                      theme="simple" value="<%=login.getName()%>" readonly="readonly"/></td>
                    </tr>

                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">제목</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="qb_subject" size="50" theme="simple"/></td>
                    </tr>
                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">내용</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <textarea name="qb_content" cols="50" rows="10" theme="simple"></textarea></td>
                    </tr>
                    <!-- <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">비밀번호</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="password" name="pwd" cssStyle="width:200px" theme="simple"/>
                        <font color="#0066CC">* 삭제.수정시 필요</font> </td>
                    </tr> -->
                  </table></td>
              </tr>
            </table>
            <table width="556" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="20" valign="middle"><img src="/images/sub_it/point_line.gif" width="556" height="3"></td>
              </tr>
              <tr>
                <td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="315" align="center">
                        
                      </td>
                      <td width="241" align="right">
                      <input type="button" onclick="check(this.form)" value="보내기"/>
                      <input type="reset" value="재입력"/>
                      </td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td height="19"></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
	</form>
</body>
</html>












