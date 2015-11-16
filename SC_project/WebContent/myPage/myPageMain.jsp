
<%@page import="silver.web.member.vo.LoginVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>MyPage </title>
	<link rel="stylesheet" href="css/nav.css" type="text/css"/>
	<link rel="stylesheet" href="css/public.css" type="text/css" />
	</head>
<body>
<%
 	LoginVO login = (LoginVO)session.getAttribute("login_ok");
%>
<jsp:include page="../header.jsp"></jsp:include>
	<div id="wrap">
		<div id="header_sub">
			<div class="web_size"
				style="background: url(/SWS/image/sub/top_img01.jpg) no-repeat center 0;">
				<div id="sub_wrap">
					<aside>
						<jsp:include page="../myPage_navi.jsp"></jsp:include>
					</aside>
					<section>
						<div id="sub_main">
							<div id="sub_title">
								<h3>마이페이지</h3>
								<div id="sub_navigation">
									<p class="path01">
										<a href="./main.jsp" class="path">홈</a> > 
										<a href="mypage.log" class="path">마이페이지</a> 
									</p>
								</div>
							</div>
							<div id="main_contents">
								<div class="mypage_info_wrap">
									<div class="mypage_info_title">
										<span class="mypage_info_title_bf">마이페이지</span>&nbsp;&nbsp;&nbsp;<b><%=login.getName() %></b>님의
										정보입니다. &nbsp;&nbsp;&nbsp;<a href="memberModifyForm.myp">
										<img src="/SWS/image/mypage/mypage_info_btn.jpg" alt="회원정보수정" align="middle"></a>
									</div>

									<div class="mypage_info_profile">
										<div class="mypage_info_profile_img">
											<img src="/SWS/image/mypage/noimg_profile.gif" alt="프로필">
										</div>

										<div class="mypage_info_profile_txt">
											<div class="mypage_info_profile_txt01">아이디 : <%=login.getTel() %></div>
											<div class="mypage_info_profile_txt01">생일 : <%=login.getBirth() %></div>
											<div class="mypage_info_profile_txt01">성별 : <%if(login.getGender().equals("male")){%>
											남자
											<%}else{ %>
											여자
											<%} %></div>
											<div class="mypage_info_profile_txt01">별명 : <%=login.getNickname() %></div>
										
										</div>
									</div>
								</div>
							</div>
							</div>
						</section>
					</div>
				</div>
				<div class="cb"></div>
				<br />
			</div>
		</div>
	<script type="text/javascript">
function change_value_url(value){
	window.open(value);
}
</script>
<script type="text/javascript" src="./js/wrest.js"></script>
<script type="text/javascript" src="https://apis.google.com/js/plusone.js"> {lang: 'ko'} </script>
</body>
</html>