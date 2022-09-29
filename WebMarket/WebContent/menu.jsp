<%@page import="java.security.Principal"%>
<%@page import="javax.servlet.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String sessionId = (String)session.getAttribute("sessionId");
	//to get remote user using getUserPrincipal()
	Principal principal = request.getUserPrincipal();
	// String remoteUser = principal.getName();

	// to get remote user using getRemoteUser()
	String remoteUser = request.getRemoteUser();
	
	//String adminSessionId = session.getAttribute(remoteUser).toString();
	session.setAttribute("adminSessionId", remoteUser);
%>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/WebMarket/welcome.jsp">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${empty sessionId and empty remoteUser}">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/loginMember.jsp"/>">로그인 </a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="/member/addMember.jsp"/>'>회원 가입</a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="/adminIndex.jsp"/>'>관리자</a></li>
					</c:when>
					<c:when test="${empty sessionId and remoteUser eq 'admin' }">
						<li style="padding-top: 7px; color: white">[<%=sessionId%>관리자]</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/addProduct.jsp"/>">상품 등록</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/editProduct.jsp?edit=update"/>">상품 수정</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/editProduct.jsp?edit=delete"/>">상품 삭제</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/logoutMember.jsp"/>">로그아웃 </a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/updateMember.jsp"/>">관리자 수정</a></li>
					</c:when>
					<c:otherwise>
						<li style="padding-top: 7px; color: white">[<%=sessionId%>님]</li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="/cart.jsp"/>'>장바구니</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/logoutMember.jsp"/>">로그아웃 </a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/updateMember.jsp"/>">회원 수정</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item" style="color:white;">sessionID:[<%=sessionId %>]</a></li>
				<li class="nav-item" style="color:white;">remoteUser:[<%=remoteUser %>]</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/products.jsp"/>">상품 목록</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/BoardListAction.do?pageNum=1"/>">게시판</a></li>
				
				
			</ul>
		</div>
	</div>
</nav>
