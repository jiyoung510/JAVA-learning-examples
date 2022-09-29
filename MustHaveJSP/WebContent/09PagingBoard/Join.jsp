<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>회원가입 페이지</h2>
	<form name="JoinFrm" action="JoinProcess.jsp" method="post" onsubmit="return validateForm(this);">
		<table border="1" width="90%">
			<tr>
				<td align="center">아이디</td>
				<td  align="center"><input type="text" name="new_id" required="required" placeholder="ID" /></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td align="center"><input type="text" name="new_name" required="required" placeholder="name" /></td>
			</tr>
			<tr>
				<td align="center">패스워드</td>
				<td align="center"><input type="password" name="new_pw" required="required" placeholder="password" /></td>
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td align="center"><input type="text" name="new_birth" required="required" placeholder="yymmdd" /></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td align="center"><input type="text" name="new_addr" placeholder="주소" /></td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td align="center"><input type="text" name="new_email" placeholder="abc@abc.com" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성 완료</button>
					<button type="reset">다시 입력</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>