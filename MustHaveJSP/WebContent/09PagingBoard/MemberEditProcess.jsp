<%@page import="membership.MemberDAO"%>
<%@page import="membership.MemberDTO"%>
<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 수정 내용 얻기
String id = request.getParameter("id");
String pass = request.getParameter("edit_pw");
String email = request.getParameter("edit_email");
String addr = request.getParameter("edit_addr");
String birth = request.getParameter("edit_birth");
String name = request.getParameter("edit_name");

// DTO에 저장
MemberDTO dto = new MemberDTO();
dto.setId(id);
dto.setName(name);
dto.setAddr(addr);
dto.setBirth(birth);
dto.setPass(pass);
dto.setEmail(email);

// DB에 반영
MemberDAO dao = new MemberDAO(application);
int affected = dao.updateMemberEdit(dto);
dao.close();

// 성공/실패 처리
if(affected == 1) {
	response.sendRedirect("List.jsp");
}
else {
	JSFunction.alertBack("수정하기에 실패하였습니다.", out);
}
%>