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
		</div>
	</div>

</head>
</html>



