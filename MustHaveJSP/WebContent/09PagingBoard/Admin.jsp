<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="membership.MemberDTO"%>
<%@ page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// DAO를 생성해 DB에 연결
MemberDAO dao = new MemberDAO(application);

int totalCount = dao.memberCount(); // 게시물 수 확인
List<MemberDTO> memberLists = dao.selectMemberList(); // 게시물 목록 받기
dao.close(); // DB 연결 닫기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 게시판</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	
	<h2>목록 보기</h2>
	<!-- 게시물 목록 테이블(표) -->
	<table border="1" width="90%">
		<!-- 각 칼럼의 이름 -->
		<tr>
			<th width="20%">가입 날짜</th>
			<th width="15%">아이디</th>
			<th width="10%">패스워드</th>
			<th width="10%">이름</th>
			<th width="15%">생년월일</th>
			<th width="10%">주소</th>
			<th width="20%">이메일</th>
		</tr>
		<!-- 목록의 내용 -->
		<%
		if(memberLists.isEmpty()) {
			// 회원이 하나도 없을 때
		%>
		<tr>
			<td colspan="5" align="center">
				가입한 회원이 없습니다.
			</td>
		</tr>
		<%
		}
		else {
			// 회원이 있을 때
			int virtualNum = 0; // 화면상에서의 게시물 번호
			for(MemberDTO dto : memberLists) {
				virtualNum = totalCount--; // 전체 게시물 수에서 시작해 1씩 감소
		%>
		<tr align="center">
			<td align="center"><%= dto.getRegidate() %></td> 
			<td align="center"> 
				<a href="MemberView.jsp?id=<%= dto.getId() %>"><%= dto.getId() %></a>
			</td>
			<td align="center"><%= dto.getPass() %></td> 
			<td align="center"><%= dto.getName() %></td> 
			<td align="center"><%= dto.getBirth() %></td>
			<td align="center"><%= dto.getAddr() %></td>
			<td align="center"><%= dto.getEmail() %></td>
		</tr>
		<%
			}
		}		
		%>
	</table>
</body>
</html>