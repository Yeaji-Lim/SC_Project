<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>은빛마을</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/nav.css" type="text/css" />
<link rel="stylesheet" href="css/public.css" type="text/css" />
<link rel="stylesheet" href="css/sub.css" type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />
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
<style type="text/css">
#myedit{position:relative; width:500px; margin-left:150px; height:auto; margin:0 auto; margin-top:280px;}
</style>
</head>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../myPage_navi.jsp"></jsp:include>

<body>

 <div id="reg">
				<form action="myedit.sc" method="post" id=myedit>
					<fieldset style="width: 400px;">
						<legend class="myinfo_edit">
							회원 정보 수정
						</legend>
						<table cellpadding="4" cellspacing="0">
							<tfoot>
								<tr>
									<td colspan="2" align="right">
									<a href="javascript:reg()"> 
									<img src="images/mypage/mypage_info_btn.gif" align="middle"/></a>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<tr>
									<td class="title"><label for="name"><img
											src="img/name.png"></label></td>
									<td>${login_ok.name}</td>
								</tr>
								<tr>
									<td class="title"><label for="id"><img
											src="img/gender.png"></label></td>
									<td class="mypage_info_profile_txt01">
									<c:if test="${'male' eq login_ok.gender }">
									남자
									</c:if>
									<c:if test="${'female' eq login_ok.gender }">
									여자
									</c:if>
									</td>
								</tr>
								<tr>
									<td class="title"><label for="birth"><img
											src="img/birth.png"></label></td>
									<td>${login_ok.birth }</td>
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
										size="30" value="${login_ok.nickname }"/></td>
								</tr>
								<tr>
									<td class="title"><label for="addr"><img
											src="img/addr.png"></label></td>
									<td><input type="text" name="addr" id="addr" size="30" value="${login_ok.addr }"/></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
			</div> 

</body>
</html>