﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Product"%>
<%@ page import="dao.ProductRepository"%>
<%@ page errorPage="exceptionNoProductId.jsp"%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>상품 상세 정보</title>
<script type="text/javascript">
   function addToCart() {
      if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
         if (!document.addForm.cartQuantity.value) {
            alert("주문수량을 입력하세요.");
            cartQuantity.select();
            cartQuantity.focus();
            return false;            
         } else if (isNaN(document.addForm.cartQuantity.value) || (document.addForm.cartQuantity.value < 0)) {
            alert("양의 정수만 입력해주세요.");
            cartQuantity.select();
            cartQuantity.focus();
            return false;
         } else
         document.addForm.submit();
      } else {      
         document.addForm.reset();
      }
   }
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
	<%
		String id = request.getParameter("id");
		
		/* ProductRepository dao = new ProductRepository("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/WebMarketDB", "root", "1234"); */
		ProductRepository dao = new ProductRepository();
		Product product = dao.getProductById(id);
		dao.close();
		
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
<%-- 				<img src="c:/upload/<%=product.getFilename()%>" style="width: 100%" /> --%>
				<img alt="" src="${pageContext.request.contextPath}/resources/images/<%=product.getFilename()%>" style="width:100%;">
				
			</div>
			<div class="col-md-6">
				<h3><%=product.getPname()%></h3>
				<p><%=product.getDescription()%>
				<p><b>상품 코드 : </b><span class="badge badge-danger"> <%=product.getProductId()%></span>
				<p><b>제조사</b> : <%=product.getManufacturer()%>
				<p><b>분류</b> : <%=product.getCategory()%>
				<p><b>재고 수</b> : <%=product.getUnitsInStock()%>
				<h4><%=product.getUnitPrice()%>원</h4>
				<p><form name="addForm" action="./addCart.jsp?id=<%=product.getProductId()%>" method="post">
					<input type="text" name="cartQuantity" placeholder="구매수량" style="width:100px"/>
					<a href="#" class="btn btn-info" onclick="addToCart()">&laquo; 장바구니에 넣기 </a>
					<a href="./cart.jsp" class="btn btn-warning"> 장바구니로 가기 &raquo;</a> 
					<a href="./products.jsp" class="btn btn-secondary"> 상품 목록 &raquo;</a>
				</form>
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
