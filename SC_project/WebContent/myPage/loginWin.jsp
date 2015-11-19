<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <style>
form{
	text-align: right;
}
</style> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login.css" type="text/css" />
<title>은빛마을</title>

<style type="text/css">
	a{
		font-family: NANUMBARUNGOTHIC, '나눔바른고딕';
	}
</style>
<script type="text/javascript">
function login(ff) {
	
	//var s_id = document.getElementById("m_id").value;
	
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
	
}
</script>
</head>
<body>




<form action="login2.sc" method="post"> 	
			<fieldset>
			<legend class="login_txt">로그인</legend>	
			<a>아이디 :</a> &nbsp;&nbsp;<input type="text" class="border" name="tel" id="tel" placeholder="전화번호" /><br/><br/> 
			<a>비밀번호 :</a> &nbsp;&nbsp;<input type="password" class="border" name="pwd" id="pwd" placeholder="비밀번호" style="margin-top:0px" /><br/> 
			<input type="button" value="로그인" id="login_bt" onclick="login()"/>
			</fieldset>
</form>	
</body>
</html>