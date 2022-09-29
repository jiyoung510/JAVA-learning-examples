/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.60
 * Generated at: 2022-09-02 06:40:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.List;
import dao.CartDAO;
import dto.Cart;
import java.util.ArrayList;
import java.net.URLDecoder;
import dto.Product;
import dao.ProductRepository;

public final class orderConfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("java.net.URLDecoder");
    _jspx_imports_classes.add("dto.Cart");
    _jspx_imports_classes.add("dto.Product");
    _jspx_imports_classes.add("dao.CartDAO");
    _jspx_imports_classes.add("dao.ProductRepository");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");

	String sessionId = session.getAttribute("sessionId").toString();
	
	String shipping_userId = "";
	String shipping_name = "";
	String shipping_shippingDate = "";
	String shipping_country = "";
	String shipping_zipCode = "";
	String shipping_addressName = "";
	
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			Cookie thisCookie = cookies[i];
			String n = thisCookie.getName();
			if (n.equals("Shipping_userId"))
				shipping_userId = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_name"))
				shipping_name = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_shippingDate"))
				shipping_shippingDate = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_country"))
				shipping_country = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_zipCode"))
				shipping_zipCode = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_addressName"))
				shipping_addressName = URLDecoder.decode((thisCookie.getValue()), "utf-8");
		}
	}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./resources/css/bootstrap.min.css\" />\r\n");
      out.write("<title>주문 정보</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\r\n");
      out.write("	<div class=\"jumbotron\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<h1 class=\"display-3\">주문 정보</h1>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"container col-8 alert alert-info\">\r\n");
      out.write("		<div class=\"text-center \">\r\n");
      out.write("			<h1>영수증</h1>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"row justify-content-between\">\r\n");
      out.write("			<div class=\"col-4\" align=\"left\">\r\n");
      out.write("				<strong>배송 주소</strong> <br> 성명 : ");
 out.println(shipping_name); 
      out.write("<br> \r\n");
      out.write("				우편번호 : ");
 	out.println(shipping_zipCode);
      out.write("<br> \r\n");
      out.write("				주소 : ");
	out.println(shipping_addressName);
      out.write('(');
	out.println(shipping_country);
      out.write(")<br>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-4\" align=\"right\">\r\n");
      out.write("				<p>	<em>배송일: ");
 out.println(shipping_shippingDate);	
      out.write("</em>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div>\r\n");
      out.write("			<table class=\"table table-hover\">			\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th class=\"text-center\">상품명</th>\r\n");
      out.write("				<th class=\"text-center\">수량</th>\r\n");
      out.write("				<th class=\"text-center\">가격</th>\r\n");
      out.write("				<th class=\"text-center\">소계</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

				int sum = 0;
				CartDAO dao = new CartDAO();
				List<Cart> cartList = dao.selectUserCart(sessionId);
				if (cartList == null)
					cartList = new Vector<Cart>();
				for (Cart cart : cartList) { // 상품리스트 하나씩 출력하기
					int total = Integer.parseInt(cart.getProductUnitPrice()) * Integer.parseInt(cart.getCartUnitsInStock());
					sum = sum + total;
			
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td class=\"text-center\"><em>");
      out.print(cart.getProductName() );
      out.write(" </em></td>\r\n");
      out.write("				<td class=\"text-center\">");
      out.print(cart.getCartUnitsInStock() );
      out.write("</td>\r\n");
      out.write("				<td class=\"text-center\">");
      out.print(cart.getProductUnitPrice() );
      out.write("원</td>\r\n");
      out.write("				<td class=\"text-center\">");
      out.print(total );
      out.write("원</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

				}
				dao.removeAllCart(sessionId);
				dao.close(); 
			
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td> </td>\r\n");
      out.write("				<td> </td>\r\n");
      out.write("				<td class=\"text-right\">	<strong>총액: </strong></td>\r\n");
      out.write("				<td class=\"text-center text-danger\"><strong>");
      out.print(sum);
      out.write(" </strong></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			</table>			\r\n");
      out.write("				<a href=\"./ShippingInfo.jsp\"class=\"btn btn-secondary\" role=\"button\"> 이전 </a>\r\n");
      out.write("				<a href=\"./thankCustomer.jsp\"  class=\"btn btn-success\" role=\"button\"> 주문 완료 </a>\r\n");
      out.write("				<a href=\"./checkOutCancelled.jsp\" class=\"btn btn-secondary\"	role=\"button\"> 취소 </a>			\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>	\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
