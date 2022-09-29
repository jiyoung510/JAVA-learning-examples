<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<span style="color: red; font-size:1.2em;">
	<%= request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") %>
	</span>
	<%
	if(session.getAttribute("UserId")==null) {
	%>
	<script>
		function validateForm(form) {
			if(!form.user_id.value) {
			alert("아이디를 입력하세요.");
			return false;
			}
			if(form.user_pw.value=="") {
				alert("패스워드를 입력하세요.");
				return false;
			}
		}
	</script>
	<form action="LoginProcess.jsp" method="post" name="loginFrm" onsubmit="return validateForm(this)";>
		<table border="1" width="90%">
			<tr>
				<td align="center">아이디</td>
				<td colspan="2" align="center"><input type="text" name="user_id" /></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td colspan="2" align="center"><input type="password" name="user_pw" /></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input style="display:inline-block;" type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
	<%
		} else { 
	%>
	<%= session.getAttribute("UserName") %> 회원님, 로그인 하셨습니다.
	<br />
	<a href="Logout.jsp">[로그아웃]</a>
	<%
		}
	%>
</body>
</html>