<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>은빛마을</title>
<link rel="stylesheet" href="css/public.css" type="text/css" />
<style type="text/css">
	#masEdit{
		position:relative; width:600px; height:auto; margin:0 auto; margin-top:260px;
	}
	
</style>
<script type="text/javascript">
function check(ff){
	

	ff.submit();
}
</script>
</head>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../masterPage_navi.jsp"></jsp:include>
<body>

	<form action="masedit.sc" method="post" id="masEdit">
		<input type="hidden" name="idx" 
			value="${vo.idx}"/>
		<input type="hidden" name="nowPage" 
			value="${nowPage }"/>
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" height="10"></td>
        </tr>
        <tr>
          <td align="center"><u><b>회원정보 수정</b></u></td>
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
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">tel</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="tel" size="50" theme="simple" value="${vo.tel }"readonly="readonly"/></td>
                    </tr>
                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">이름</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="name" size="50" theme="simple" value="${vo.name }"readonly="readonly"/></td>
                    </tr>
                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">주소</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="addr" size="50" theme="simple" value="${vo.addr }"/></td>
                    </tr>
					  <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">별명</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="nickname" size="50" theme="simple" value="${vo.nickname }"/></td>
                    </tr>


                    <tr>
                      <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">비밀번호</font></td>
                      <td bgcolor="#F2F7F9" align="left"> <input type="password" name="pwd" cssStyle="width:200px" theme="simple"/>
                        <font color="#0066CC"></font> </td>
                    </tr>
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












