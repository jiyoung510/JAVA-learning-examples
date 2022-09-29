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
<!-- 로그인/회원가입  -->
	<table border="1" width="90%">
	<tr>
		<td align="center">
			<% if (session.getAttribute("UserId") == null) { %>
			<button type="button" onclick="location.href='../06Session/LoginForm.jsp';">로그인</button>
			<!-- 회원 가입 -->
			<button type="button" onclick="location.href='../09PagingBoard/Join.jsp';">회원가입</button>
			<% } else if(session.getAttribute("UserId").equals("admin")) { %>
				<button type="button" onclick="location.href='../06Session/Logout.jsp';">로그아웃</button>
				<button type="button" onclick="location.href='../09PagingBoard/Admin.jsp';">관리자 페이지</button>
			<% } else {%>
			<button type="button" onclick="location.href='../06Session/Logout.jsp';">로그아웃</button>
			<button type="button" onclick="../09PagingBoard/MemberEdit.jsp?id=<%= session.getAttribute("UserId") %>';">회원정보수정</button>
			<% } %>
		</td>
	</tr>
</table>