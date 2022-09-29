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
		out.print("<head><title>JSP프로그래밍 : 실습환경 구축 확인을 위한 과제</title></head>");
		out.print("<body><h2>JSP프로그래밍 : 실습환경 구축 확인을 위한 과제</h2>");
		out.print("<hr>");
		out.print("<div>0) 이미지(ex: 본인사진, 명함)<img src='http://localhost/jspbook/images/JSP.png' style='display:block'></div>");
		out.print("<div>1) 소속학과 : 컴퓨터공학과</div>");
		out.print("<div>2) 학번 : 2021109577</div>");
		out.print("<div>3) 이름 : 홍지영</div>");
		out.print("<div>4) 학년 : 4학년</div>");
		out.print("<div>5) 집위치(시,구,동) : 수원시 권선구 권선동</div>");
		out.print("<div>6) 직장 위치(시,구,동) : 서울시 성동구 왕십리로</div>");
		out.print("<div>7) 회사명 : 한양사이버대학교</div>");
		out.print("<div>8) 담당업무 : 재학생</div>");
		out.print("<div>(*재직 중인 직장이 없어 6, 7, 8번 항목을  학교 주소, 학교명, 신분으로 대체합니다.)</div>");
		out.print("<div>9) 수강동기 : 새로운 프로그래밍 기법을 배워보기 위해서 입니다.</div>");
		out.print("<div>10) 바라는 점 : 기초부터 다져갈 수 있었으면 좋겠습니다. 잘 부탁드립니다.</div>");
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
