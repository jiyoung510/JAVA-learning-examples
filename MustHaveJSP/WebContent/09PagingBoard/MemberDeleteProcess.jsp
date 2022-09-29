<%@page import="membership.MemberDAO"%>
<%@page import="membership.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./IsLoggedIn.jsp"%>
<%
String id = request.getParameter("id"); 

MemberDTO dto = new MemberDTO();             
MemberDAO dao = new MemberDAO(application);  
dto = dao.memberView(id);  

String sessionId = session.getAttribute("UserId").toString(); 

int delResult = 0;

if (sessionId.equals(dto.getId())) {  
    dto.setId(id);
    delResult = dao.deleteMember(dto);
    dao.close();

    if (delResult == 1) { 
        JSFunction.alertLocation("탈퇴되었습니다.", "List.jsp", out); 
    } else {
        JSFunction.alertBack("게시물이 남아있는 회원은 탈퇴할 수 없습니다. \\n탈퇴에 실패하였습니다.", out);
    } 
}
else if (sessionId.equals("admin")) {
	dto.setId(id);
    delResult = dao.deleteMember(dto); 
    dao.close();

    if (delResult == 1) { 
        JSFunction.alertLocation("관리자 권한으로 탈퇴되었습니다.", "List.jsp", out); 
    } else {
        JSFunction.alertBack("게시물이 남아있는 회원은 탈퇴시킬 수 없습니다. \\n탈퇴에 실패하였습니다.", out);
    } 
}
else { 
    JSFunction.alertBack("관리자만 삭제할 수 있습니다.", out);

    return;
}
%>