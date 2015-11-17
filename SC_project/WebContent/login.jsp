<%@page import="silver.web.member.vo.LoginVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>


</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>



	<div id="container">
		<div id="wrap">
			<% 

	LoginVO login = (LoginVO)session.getAttribute("login_ok");

	//Object obj = session.getAttribute("login_ok");

	if(login == null){
%>
			<div id="login">
			<form action="login.sc" method="post"> 	
			<fieldset>	
			전화번호 : <input type="text" class="border" name="tel" id="tel" placeholder="전화번호" /><br/> 
			비밀번호 : <input type="password" class="border" name="pwd" id="pwd" placeholder="비밀번호" style="margin-top:0px" /><br/> 
			<input type="button" value="회원가입" onclick="openReg()" style="margin-top:10px; width:70px; height:25px;" /> 
			<input type="button" value="로그인" id="log_bt" onclick="login()" style="margin-top:10px; width:50px; height:25px;" />
			</fieldset>
			</form>	
			</div>
			<%
	}else{
		//세션에 mem_vo라는 이름으로 
		//저장된 객체가 있는 경우다.
		//이때
		// 그것을 MemberVO로 변환한다.
		
%>
			<div id="g_form">
				<span class="u_name">${login_ok.name} </span> (<span class="u_id">${login_ok.tel}</span>)님 로그인되었습니다.
				<br/>
				
					<input type="button" value="로그아웃" onclick="logout()" />
					<input type="button" value="마이페이지" onclick="myDisk()" />
				
			</div>
			<% 
	}//if문의 끝!
%>
			<!-- <div id="reg">
				<form action="reg.sc" method="post">
					<fieldset>
						<legend>
							<img src="img/reg.png" />
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
											src="img/name.png"></label></td>
									<td><input type="text" name="name" id="name" size="12" /></td>
								</tr>
								<tr>
									<td class="title"><label for="id"><img
											src="img/gender.png"></label></td>
									<td><select name="gender">
											<option value="male">남</option>
											<option value="female">여</option>
									</select></td>
								</tr>
								<tr>
									<td class="title"><label for="birth"><img
											src="img/birth.png"></label></td>
									<td><input type="text" name="birth" id="birth" size="8" /></td>
								</tr>
								<tr>
									<td class="title"><label for="phone"><img
											src="img/phone.png"></label></td>
									<td><select name="tel">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="017">017</option>
											<option value="019">019</option>
									</select>-<input type="text" name="tel" id="tel" size="4" /> -<input
										type="text" name="tel" id="tel" size="4" /></td>
									<td><img name="check" onclick="open()" src="img/check.png">
									</td>
								</tr>
								<tr>
									<td class="title"><label for="pwd"><img
											src="img/pwd.png"></label></td>
									<td><input type="password" name="pwd" id="pwd" size="12" /></td>
								</tr>
								<tr>
									<td class="title"><label for="repwd"><img
											src="img/pwd.png"></label></td>
									<td><input type="password" name="repwd" id="repwd"
										size="12" /></td>
								</tr>
								<tr>
									<td class="title"><label for="nickname"><img
											src="img/nickname.png"></label></td>
									<td><input type="text" name="nickname" id="nickname"
										size="30" /></td>
								</tr>
								<tr>
									<td class="title"><label for="addr"><img
											src="img/addr.png"></label></td>
									<td><input type="text" name="addr" id="addr" size="30" /></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
			</div>
 -->
		</div>
	</div>

</head>
</html>



