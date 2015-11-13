<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#infoEdit{position:relative; width:600px; height:auto; margin:0 auto; margin-top:255px;}
</style>
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
</head>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../board_navi.jsp"></jsp:include>
<body>

	<form action="edit.sc" method="post" 
	enctype="multipart/form-data" id="infoEdit">
		<input type="hidden" name="seq" value="${seq }" />
		<input type="hidden" name="nowPage" value="${nowPage }"/>
		<input type="hidden" name="uploadFileName" value="${vo.uploadFileName }"/> 
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" height="10"></td>
        </tr>
        <tr>
          <td align="center"><u><b>글 수정하기</b></u></td>
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
                      <td bgcolor="#F2F7F9" align="left"> <input type="text" name="writer" value="${vo.writer }"cssStyle="width:100px" theme="simple"></td>
     </tr>
						
      <tr>
        <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">제목</font></td>
       <td bgcolor="#F2F7F9" align="left"> <input type="text" name="title" value="${vo.title}" size="50" theme="simple"/></td>
      </tr>
     <tr>
       <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">내용</font></td>
       <td bgcolor="#F2F7F9" align="left"> <textarea name="content" cols="50" rows="10" theme="simple">${vo.content }</textarea></td>
      </tr>
       <tr>
       <td height="20" align="center" bgcolor="#669AB3"><font color="#FFFFFF">첨부파일</font></td>
       <td bgcolor="#F2F7F9" align="left">
        <input type="file" name="upload" cssStyle="width:300px" theme="simple"/>
      <c:if test="${vo.uploadFileName ne '' }"><span style="color:5d5d5d">(${vo.uploadFileName })</span></c:if>
      
       </td>
      </tr>
       <tr>
       
   <input type="hidden" name="pwd" value="1" cssStyle="width:200px" theme="simple"/>
        
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