<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");   

MemberDAO dao = new MemberDAO(application);  
MemberDTO dto = dao.memberView(id);      
dao.close();                             
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 게시판</title>
<script>
function deleteMember() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.MemberFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "MemberDeleteProcess.jsp";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}
</script>
</head>
<body>
<jsp:include page="../Common/Link.jsp" />
<h2>관리자 게시판 - 상세 보기</h2>
<form name="MemberFrm">
    <input type="hidden" name="id" value="<%= id %>" />  

    <table border="1" width="90%">
        <tr>
            <td>가입 날짜</td>
            <td colspan="3"><%= dto.getRegidate() %></td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><%= dto.getId() %></td>
            <td>비밀번호</td>
            <td><%= dto.getPass() %></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><%= dto.getName() %></td>
            <td>생년월일</td>
            <td><%= dto.getBirth() %></td> 
        </tr>
         <tr>
            <td>주소</td>
            <td><%= dto.getAddr() %></td>
            <td>이메일</td>
            <td>
                <%= dto.getEmail() %></td> 
        </tr>
        <tr>
            <td colspan="4" align="center">
            <%
            if (session.getAttribute("UserId") != null
                    && session.getAttribute("UserId").toString().equals("admin")) {
            %>
                <button type="button"
                        onclick="location.href='MemberEdit.jsp?id=<%= dto.getId() %>';">
                    수정하기</button>
                <button type="button" onclick="deleteMember();">탈퇴하기</button> 
            <%
            }
            %>
                <button type="button" onclick="location.href='Admin.jsp';">
                    목록 보기
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>