<%@page import="silver.web.member.vo.LoginVO"%>

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
				<div id="l_form">
					<form action="login.sc" method="post">
						<fieldset>
							<legend>
								<img src="img/login.png" />
							</legend>
							<label for="tel">tel:</label> <input type="text" name="tel"
								id="tel" size="8" /><br /> <label for="pwd">pwd:</label> 
								<input type="password" name="pwd" id="pwd" size="8" /><br/> 
								<input type="button" value="Registry" onclick="openReg()" /> 
								<input type="button" value="Login" id="log_bt" onclick="login()" />
						</fieldset>
					</form>
				</div>
			</div>
			<%
	}else{
		//세션에 mem_vo라는 이름으로 
		//저장된 객체가 있는 경우다.
		//이때
		// 그것을 MemberVO로 변환한다.
		
%>
			<div id="g_form">
				<span class="u_name">${login_ok.name } </span> (<span class="u_id">${login_ok.tel }
				</span>)님 환영합니다.
				<p>
					<input type="button" value="Logout" onclick="logout()" />
				</p>
				<p>
					<input type="button" value="My Disk" onclick="myDisk()" />
				</p>
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




