
<%@page import="silver.web.member.vo.LoginVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MyPage</title>
<link rel="stylesheet" href="css/nav.css" type="text/css" />
<link rel="stylesheet" href="css/public.css" type="text/css" />
<link rel="stylesheet" href="css/sub.css" type="text/css" />

<script type="text/javascript">
	function openMsg() {
		open('msg_list.sc','','left=50, top=50, width=600, height=300, scrollbars=0');
	}
</script>

</head>
<body>
	<%
 	LoginVO login = (LoginVO)session.getAttribute("login_ok");
%>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../myPage_navi.jsp"></jsp:include>

	<h3>마이페이지</h3>


	<div id="main_contents">
		<div class="mypage_info_wrap">
			<div class="mypage_info_title">
				<span class="mypage_info_title_bf">마이페이지</span>&nbsp;&nbsp;&nbsp;<b><%=login.getName() %></b>님의
				정보입니다. &nbsp;&nbsp;&nbsp;
				<a href="modifymypage.sc"> 
				<img src="images/mypage/mypage_info_btn.jpg" alt="회원정보수정" align="middle"></a>
				 &nbsp;&nbsp;&nbsp;
				<a href="javascript:openMsg()">쪽지보기</a>
			</div>

			<div class="mypage_info_profile">
				<div class="mypage_info_profile_img">
					<img src="images/mypage/noimg_profile.gif" alt="프로필">
				</div>

				<div class="mypage_info_profile_txt">
					<div class="mypage_info_profile_txt01">
						아이디 :
						<%=login.getTel() %></div><br/>
					<div class="mypage_info_profile_txt01">
						별명 :
						<%=login.getNickname() %></div><br/>
					<div class="mypage_info_profile_txt01">
						생일 :
						<%=login.getBirth() %></div><br/>
					<div class="mypage_info_profile_txt01">
						성별 :
						<%if(login.getGender().equals("male")){%>
						남자
						<%}else{ %>
						여자
						<%} %>
					</div><br/>
					<div class="mypage_info_profile_txt01">
						주소 :
						<%=login.getAddr() %></div><br/>
					

				</div>
			</div>
		</div>
	</div>
	
	<br />


</body>
</html>