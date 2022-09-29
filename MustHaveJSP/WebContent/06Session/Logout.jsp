<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 방법 1 : 회원 인증 정보 삭제(session에 저장된 아이디와 이름을 제거한다.)
session.removeAttribute("UserId");
session.removeAttribute("UserName");

// 방법2 : 모든 속성을 한번에 제거한다.
session.invalidate(); // 세션 자체를 무효화시킨다.

// 속성 삭제 후 페이지 이동
response.sendRedirect("LoginForm.jsp");
%>