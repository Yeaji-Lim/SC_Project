<%@page import="silver.web.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

	<% LoginVO login = (LoginVO)session.getAttribute("login_ok"); %>
<script type="text/javascript">
function openReg(){
	
	open('reg.sc','','left=50, top=50, width=400, height=410, scrollbars=0');
}
</script>


	<div id="top_link">
		<ul class="top_link_ul">
			<li class="top_link_li01"><a
				href="javascript:location.href='/SC_project'">홈</a></li>
			<%
				if (login != null) {
			%>
			<li class="top_link_li01"><a href="mypage.sc">마이페이지</a></li>
			<li class="top_link_li01"><a href="logout.jsp">로그아웃</a></li>
			<%
				} else {
			%>
			<li class="top_link_li01"><a href="javascript:openReg()" class="outlogin_a">회원가입</a></li>
			<li class="top_link_li01"><a href="login.sc">로그인</a></li>
			<%
				}
			%>
		</ul>
	</div>



	<div id="header">
		<p id="top_logo">
			<a href="javascript:location.href='/SC_project'"> <img
				src="images/sc_logo.png" style="width: 200px; height: 80px;" /></a>
		</p>

		<div id="top_navi">
			<ul>

				<li id="menu1" class="main_menu fl"><span class="main_menu">
						<a href="javascript:location.href='/SC_project'"
						class="topmenu_a01">홈</a>
				</span></li>

				<li id="menu2" class="main_menu fl"><span class="main_menu">
						<a href="/introduce.jsp" class="topmenu_a01">소개</a>
				</span></li>

				<li id="menu4" class="main_menu fl"><span class="main_menu">
						<a href="notice.sc" class="topmenu_a01">게시판</a>
				</span></li>

				<li id="menu3" class="main_menu fl"><span class="main_menu">
						<a href="" class="topmenu_a01">요양사를 소개합니다</a>
				</span></li>

				<li id="menu7" class="main_menu fl"><span class="main_menu">
						<a href="info.sc" class="topmenu_a01">정보게시판</a>
				</span></li>

			</ul>

		</div>


		<p id="banner">
			<img src="images/top_banner_garden.gif"
				style="width: 1600px; height: 150px;" />
		</p>
	</div>


	<div id="bottom">
		<address>Copyright Seven Stars &copy; allright inc.</address>
	</div>



