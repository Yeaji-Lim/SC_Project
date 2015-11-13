<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function reg(){
		
	//현재 문서의 두번째 폼요소내에 있는 입력요소들을 모두
	//입력값을 확인하기 위한 반복문
	var pwd = document.forms[0].pwd.value;
	var repwd = document.forms[0].repwd.value;
	
	if(pwd != repwd)
		{
			alert("비밀번호가 다릅니다.");
			document.forms[0].pwd.value="";
			document.forms[0].repwd.value="";
			document.forms[0].pwd.focus();
			return;	
		}
	
	for(var i=0; i<document.forms[0].elements.length; i++){
		if(document.forms[0].elements[i].value == ""){
			//폼의 자식요소들 중 특정 요소의 값이 비어있다면...
			alert(document.forms[0].elements[i].id+"을(를) 입력하세요!");
			
			//해당 요소로 커서 이동
			document.forms[0].elements[i].focus();
			return;
		}
	}
	
	//if문 안에 있는 return문을 만나지 않았을 경우!
	document.forms[0].submit();
	
	
	
}


</script>
</head>
<body>

 <div id="reg">
				<form action="reg.sc" method="post">
					<fieldset>
						<legend>
							<img src="../img/reg.png" />
						</legend>
						<table cellpadding="4" cellspacing="0">
							<tfoot>
								<tr>
									<td colspan="2" align="right"><input type="button"
										value="회원가입하기" onclick="reg()" /></td>
								</tr>
							</tfoot>
							<tbody>
								<tr>
									<td class="title"><label for="name"><img
											src="../img/name.png"></label></td>
									<td><input type="text" name="name" id="이름" size="12" /></td>
								</tr>
								<tr>
									<td class="title"><label for="id"><img
											src="../img/gender.png"></label></td>
									<td><select name="gender">
											<option value="male">남</option>
											<option value="female">여</option>
									</select></td>
								</tr>
								<tr>
									<td class="title"><label for="birth"><img
											src="../img/birth.png"></label></td>
									<td><input type="text" name="birth" id="생년월일" size="8" /></td>
								</tr>
								<tr>
									<td class="title"><label for="phone"><img
											src="../img/phone.png"></label></td>
									<td><select name="tel">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="017">017</option>
											<option value="019">019</option>
									</select>-<input type="text" name="tel" id="tel" size="4" /> -<input
										type="text" name="tel" id="tel" size="4" /></td>
									<td><img name="check" onclick="open()">
									</td>
								</tr>
								<tr>
									<td class="title"><label for="pwd"><img
											src="../img/pwd.png"></label></td>
									<td><input type="password" name="pwd" id="비밀번호" size="12" /></td>
								</tr>
								<tr>
									<td class="title"><label for="repwd"><img
											src="../img/pwd.png"></label></td>
									<td><input type="password" name="repwd" id="repwd"
										size="12" /></td>
								</tr>
								<tr>
									<td class="title"><label for="nickname"><img
											src="../img/nickname.png"></label></td>
									<td><input type="text" name="nickname" id="별명"
										size="30" /></td>
								</tr>
								<tr>
									<td class="title"><label for="addr"><img
											src="../img/addr.png"></label></td>
									<td><input type="text" name="addr" id="주소" size="30" /></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
			</div> 

</body>
</html>