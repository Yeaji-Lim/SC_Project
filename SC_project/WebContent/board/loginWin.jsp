<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
form{
	text-align: right;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function login() {
	
	//		var s_id = document.getElementById("m_id").value;
	var tel = document.forms[0].tel.value;
	var pwd = document.forms[0].pwd.value;

	if (tel == "") {
		alert("아이디를 입력하세요");
		document.forms[0].id.focus();
		return;
	}
	if (pwd == "") {
		alert("비밀번호를 입력하세요");
		document.forms[0].pwd.focus();
		return;
	}
	document.forms[0].submit();
	window.close();
	
	
	
	
	
}
</script>
</head>
<body>




<form action="login.sc" method="post"> 	
			<fieldset>	
			전화번호 :<input type="text" class="border" name="tel" id="tel" placeholder="전화번호" /><br/> 
			비밀번호 :<input type="password" class="border" name="pwd" id="pwd" placeholder="비밀번호" style="margin-top:0px" /><br/> 
			<input type="button" value="로그인" id="log_bt" onclick="login()" style="margin-top:10px; width:70px; height:25px;" />
			</fieldset>
</form>	
</body>
</html>