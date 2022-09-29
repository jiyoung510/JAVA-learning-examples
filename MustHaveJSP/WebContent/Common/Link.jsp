<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 String id = request.getParameter("id");	
 
 MemberDAO dao = new MemberDAO(application);	
 MemberDTO dto = dao.memberView(id);	 

 dao.close(); // DB 연결 해제
 %>
<table border="1" width="90%">
	<tr>
		<td align="center">
			<% if (session.getAttribute("UserId") == null) { %>
			<a href="../06Session/LoginForm.jsp" style="display:inline-block;width:20%;">로그인</a>
			<!-- 회원 가입 -->
			<a href="../09PagingBoard/Join.jsp" style="display:inline-block;width:20%;">회원가입</a>
			<% } else if(session.getAttribute("UserId").equals("admin")) { %>
				<a href="../06Session/Logout.jsp" style="display:inline-block;width:20%;">로그아웃</a>
				<a href="../09PagingBoard/Admin.jsp" style="display:inline-block;width:20%;">관리자 페이지</a>
			<% } else {%>
			<a href="../06Session/Logout.jsp" style="display:inline-block;width:20%;">로그아웃</a>
			<a href="../09PagingBoard/MemberEdit.jsp?id=<%= session.getAttribute("UserId") %>" style="display:inline-block;width:20%;">회원정보수정</a>
			<% } %>
			<a href="../09PagingBoard/List.jsp" style="display:inline-block;width:20%;">게시판(페이징X)</a>
			<a href="../09PagingBoard/List.jsp" style="display:inline-block;width:20%;">게시판(페이징O)</a>
		</td>
	</tr>
</table>