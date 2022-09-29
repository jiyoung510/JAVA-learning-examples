package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>JSP���α׷��� : �ǽ�ȯ�� ���� Ȯ���� ���� ����</title></head>");
		out.print("<body><h2>JSP���α׷��� : �ǽ�ȯ�� ���� Ȯ���� ���� ����</h2>");
		out.print("<hr>");
		out.print("<div>0) �̹���(ex: ���λ���, ����)<img src='http://localhost/jspbook/images/JSP.png' style='display:block'></div>");
		out.print("<div>1) �Ҽ��а� : ��ǻ�Ͱ��а�</div>");
		out.print("<div>2) �й� : 2021109577</div>");
		out.print("<div>3) �̸� : ȫ����</div>");
		out.print("<div>4) �г� : 4�г�</div>");
		out.print("<div>5) ����ġ(��,��,��) : ������ �Ǽ��� �Ǽ���</div>");
		out.print("<div>6) ���� ��ġ(��,��,��) : ����� ������ �սʸ���</div>");
		out.print("<div>7) ȸ��� : �Ѿ���̹����б�</div>");
		out.print("<div>8) ������ : ���л�</div>");
		out.print("<div>(*���� ���� ������ ���� 6, 7, 8�� �׸���  �б� �ּ�, �б���, �ź����� ��ü�մϴ�.)</div>");
		out.print("<div>9) �������� : ���ο� ���α׷��� ����� ������� ���ؼ� �Դϴ�.</div>");
		out.print("<div>10) �ٶ�� �� : ���ʺ��� ������ �� �־����� ���ڽ��ϴ�. �� ��Ź�帳�ϴ�.</div>");
		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}