package model2.mvcboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/mvcboard/view.mit")
public class ViewController extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		//�Խù� ��������
		MVCBoardDAO dao = new MVCBoardDAO();
		String idx = req.getParameter("idx");
		dao.updateVisitCount(idx); //��ȸ�� 1�� ����
		MVCBoardDTO dto = dao.selectView(idx); //�ε��� �˻�
		dao.close();
		
		//�ٹٲ� ó��
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		//�Խù�(dto) ���� �� ��� ������
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/14MVC/View.jsp").forward(req, resp);
	}
	
}