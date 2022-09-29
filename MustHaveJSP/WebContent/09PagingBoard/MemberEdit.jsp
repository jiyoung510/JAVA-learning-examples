<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 String id = request.getParameter("id");	
 
 MemberDAO dao = new MemberDAO(application);	
 MemberDTO dto = dao.memberView(id);	 

 dao.close(); // DB 연결 해제
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<script type="text/javascript">
function validateForm(form) {
	if(form.edit_pw.value=="") {
		alert("패스워드를 입력하세요.");
		return false;
	}
	if(form.edit_name.value=="") {
		alert("이름을 입력하세요.");
		return false;
	}
	if(form.edit_addr.value=="") {
		alert("주소를 입력하세요.");
		return false;
	}
	if(form.adit_email.value=="") {
		alert("이메일을 입력하세요.");
		return false;
	}
	if(form.edit_birth.value=="") {
		alert("생년월일 입력하세요.");
		return false;
	}
}
function deleteMember() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.MemberEditFrm;       // 이름(name)이 "MemberEditFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "MemberDeleteProcess.jsp";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}
</script>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>회원 정보 수정 페이지</h2>
	<form name="MemberEditFrm" action="MemberEditProcess.jsp" method="post" onsubmit="return validateForm(this);">
		<input type="hidden" name="id" value="<%= dto.getId() %>" />
		
		<table border="1" width="90%">
			<tr>
				<td align="center">이름</td>
				<td align="center"><input type="text" name="edit_name" required="required" placeholder="name" /></td>
			</tr>
			<tr>
				<td align="center">패스워드</td>
				<td align="center"><input type="password" name="edit_pw" required="required" placeholder="password" /></td>
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td align="center"><input type="text" name="edit_birth" required="required" placeholder="yymmdd" /></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td align="center"><input type="text" name="edit_addr" placeholder="주소" /></td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td align="center"><input type="text" name="edit_email" placeholder="abc@abc.com" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성 완료</button>
					<button type="reset">다시 입력</button>
					<button type="button" onclick="deleteMember();">탈퇴하기</button> 
					<button type="button" onclick="location.href='List.jsp';">목록 보기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>