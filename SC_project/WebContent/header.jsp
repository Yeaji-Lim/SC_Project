<%@page import="silver.web.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/public.css" type="text/css" />
<title>Web Project</title>

</head>
<body>
	<% LoginVO login = (LoginVO)session.getAttribute("login_ok"); %>

	<div id="mypage">
		<ul class="top_link_ul">
			<li class="top_link_li01"><a href="javascript:location.href='/SC_project'">홈</a></li>
			<%
				if (login != null) {
			%>
			<li class="top_link_li01"><a href="/mypage/mypage.sc">마이페이지</a></li>
			<li class="top_link_li01"><a href="/mypage/logout.sc">로그아웃</a></li>
			<%
				} else {
			%>
			<li class="top_link_li01"><a href="#top"
				onclick="javascript:window.open('/mypage/regForm.sc','','left=50, top=50, width=600, height=400, scrollbars=0');"
				class="outlogin_a">회원가입</a></li>
			<li class="top_link_li01"><a href="/mypage/login.sc">로그인</a></li>
			<%
				}
			%>
		</ul>
	</div>



	<div id="header">
		<p id="logo">
		<a href="javascript:location.href='/SC_project'">
		<img src="img/happysilver.jpg" style="width: 100px; height: 50px;" /></a>
	</p>

	<div id="top_navi">
						<ul id="top_navi_mainmenu">
							<li id="menu1" class="main_menu fl"></li>
							<li id="menu1" class="main_menu fl"></li>

							<li id="menu1" class="main_menu fl">
							<span class="main_menu">
							<a href="javascript:location.href='/SC_project'" class="topmenu_a01">홈</a>
							</span>
							</li>

							<li id="menu2" class="main_menu fl">
							<span class="main_menu">
							<a href="/introduce.jsp" class="topmenu_a01">소개</a>
							</span>
							</li>

							<li id="menu4" class="main_menu fl">
							<span class="main_menu">
							<a href="notice.sc" class="topmenu_a01">게시판</a>
							</span>
							</li>

							<li id="menu3" class="main_menu fl">
							<span class="main_menu">
							<a href="" class="topmenu_a01">요양사를 소개합니다</a>
							</span>
							</li>
							
							<li id="menu7" class="main_menu fl">
							<span class="main_menu">
							<a href="info.sc" class="topmenu_a01">정보게시판</a>
							</span>
							</li>

						</ul>

					</div>





		<!-- <ul id="topmenu">
			<li><a href="javascript:location.href='/SC_project'">홈</a></li>
			<li><a href="notice.sc">게시판</a></li>
			<li><a href="www.naver.com"></a></li>
			<li><a href="www.naver.com"></a></li>
		</ul>
 		-->
 		
		<p id="banner">
			<img src="images/top_banner_garden.gif"
				style="width: 1600px; height: 150px;" />
		</p>
	</div>


	<div id="bottom">
		<address>Copyright Seven Stars &copy; allright inc.</address>
	</div>


</body>
</html>
