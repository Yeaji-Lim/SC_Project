
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>은빛마을</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	function check(ff){
		//유효성 검사
		ff.submit();
	}
</script>
</head>
<body>
<%
	String send_tel = request.getParameter("send_tel");
%>
	<form action="msg_reply.sc" method="POST">
	<%-- <input type="hidden" name="request_tel" value="<%=request_tel %>"/> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" height="10"></td>
        </tr>
        <tr>
          <td align="center"><b>답장쓰기</b></td>
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
                      <td width="90" height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">보내는사람</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="send_tel" cssStyle="width:100px" theme="simple" value="${login_ok.tel}"/></td>
                    </tr>
					<tr>
						<td width="90" height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">받는사람</font></td>
						<td bgcolor="#F2F7F9" align="left"> <input type="text" name="request_tel" cssStyle="width:100px" theme="simple" value="<%=send_tel %> "/></td>
                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">제목</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="subject" size="50" theme="simple"/></td>
                    </tr>
                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">내용</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <textarea name="content" cols="50" rows="10" theme="simple"></textarea></td>
                    </tr>
                   
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
                      <td width="315" align="center">
                        
                      </td>
                      <td width="241" align="right">
                      <input type="button" onclick="check(this.form)" value="보내기"/>
                      <input type="button" onclick="javascript:location.href='msg_list.sc'" value="뒤로"/>
                      
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