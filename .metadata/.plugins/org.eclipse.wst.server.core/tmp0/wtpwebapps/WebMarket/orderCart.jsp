<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@page import="common.JSFunction"%>
<%@page import="dao.CartDAO"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Product"%>
<%@ page import="dao.ProductRepository"%>
<%
	String userId = session.getAttribute("sessionId").toString();
	if (userId == null || userId.trim().equals("")) {
		response.sendRedirect("products.jsp");
		return;
	}
	
	CartDAO dao = new CartDAO();
	List<Cart> cartList = dao.selectUserCart(userId); 
	dao.close();
	if(cartList.isEmpty()){
		JSFunction.alertBack(response, "장바구니가 비어있습니다.");
	} else {
		for(Cart cart : cartList) {
			if(Integer.parseInt(cart.getUnitsInStock()) < Integer.parseInt(cart.getCartUnitsInStock())) {
				JSFunction.alertBack(response, "상품 재고가 부족합니다.");}
		} 
		/*  RequestDispatcher dispatcher = request.getRequestDispatcher("shippingInfo.jsp");
		dispatcher.forward(request, response); 	  */ 
	}
%>
