<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="silver.web.board.vo.FreeBoardVO"%>
<%@page import="silver.web.board.dao.FreeBoardDAO"%>
<%@page import="silver.web.board.control.FreeBoardControl"%>
<%@page import="silver.web.board.vo.NoticeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/public.css" type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />
<link rel="stylesheet" href="css/main.css" type="text/css" />

<script type="text/javascript">
	//회원 가입 폼을 보여주는 함수
	function regView() {
		//현재 문서에서 id가 "reg"인 요소를 검색한다.
		var reg_div = document.getElementById("reg");
		//검색된 요소를 화면에 보이도록 속성 변경
		reg_div.style.display = "block";
	}

	function reg() {
		//현재 문서의 두번째 폼요소내에 있는 입력요소들을 모두
		//입력값을 확인하기 위한 반복문
		var pwd = document.forms[1].pwd.value;
		var repwd = document.forms[1].repwd.value;

		if (pwd != repwd) {
			alert("비밀번호가 다릅니다.");
			document.forms[1].pwd.value = "";
			document.forms[1].repwd.value = "";
			document.forms[1].pwd.focus();
			return;
		}

		for (var i = 0; i < document.forms[1].elements.length; i++) {
			if (document.forms[1].elements[i].value == "") {
				//폼의 자식요소들 중 특정 요소의 값이 비어있다면...
				alert(document.forms[1].elements[i].name + "을(를) 입력하세요!");

				//해당 요소로 커서 이동
				document.forms[1].elements[i].focus();
				return;
			}
		}

		//if문 안에 있는 return문을 만나지 않았을 경우!
		document.forms[1].submit();
	}

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
	}
</script>

</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>


	<jsp:include page="login.jsp"></jsp:include>

	<%
		request.setCharacterEncoding("utf-8");
	%>
	<!--게시판들 보기 시작-->
	<div class="main_small_board">
	<div class="free_small">
		<p class="freetitle"><a>자유게시판</a></p>
		<c:forEach var="vo" items="${list1 }" varStatus="stat">
			<div class="freebox">
			<div class="left">
				<a href="#" class="news_a">${vo.fb_subject }<span style="font-size: 8pt;"></span></a>
			</div>
			
			<%-- <fmt:parseDate value="${vo.fb_regdate}" var="dateFmt" pattern="yyyyMMddHHmmss"/>
      		<fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/> --%>
			
			<div class="right">${vo.fb_regdate}</div>
			</div>
			
		</c:forEach>
	</div>
	</div>

	<div class="main_small_board">
	<div class="match_small">
		<p class="matchtitle"><a>요양사를 소개합니다</a></p>
		<c:forEach var="vo" items="${list2 }" varStatus="stat">
			<div class="matchbox">
			<div class="left">
				<a href="#" class="news_a">${vo.mb_subject }<span
					style="font-size: 8pt;"></span></a>
			</div>
			<div class="right">${vo.mb_regdate }</div>
			</div>
		</c:forEach>
	</div>
	</div>

	<div class="main_small_board">
	<div class="notice_small">
	<p class="noticetitle"><a>공지사항</a></p>
		<c:forEach var="vo" items="${list3 }" varStatus="stat">
			<div class="noticebox">
			<div class="left">
				<a href="#" class="news_a">${vo.subject }<span
					style="font-size: 8pt;"></span></a>
			</div>
			<div class="right">${vo.write_date }</div>
			</div>
		</c:forEach>
	</div>
	</div>
	<!--게시판들 보기 끝  -->

	



</body>
</html>