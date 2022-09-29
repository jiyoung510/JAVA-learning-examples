package model2.mvcboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fileupload.FileUtil;
import utils.JSFunction;

@WebServlet("/mvcboard/pass.mit")
public class PassController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/14MVC/Pass.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �Ű����� ����
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		
		// ��й�ȣ Ȯ��
		MVCBoardDAO dao = new MVCBoardDAO();
		boolean confirmed = dao.confirmPassword(pass, idx);
		dao.close();
		
		if(confirmed) { // ��й�ȣ ��ġ Ȯ��
			if(mode.equals("edit")) { // ���� ���
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				resp.sendRedirect("../mvcboard/edit.mit?idx=" + idx);
			} else if(mode.equals("delete")) { // ���� ���
				dao = new MVCBoardDAO();
				MVCBoardDTO dto = dao.selectView(idx);
				int result = dao.deletePost(idx);
				dao.close();
				if(result == 1) { // ���� ���� ���ϰ� -> ÷�����ϱ��� ����
					String saveFileName = dto.getSfile();
					FileUtil.deleteFile(req, "/Uploads", saveFileName);
				}
				JSFunction.alertLocation(resp, "�����Ǿ����ϴ�.", "../mvcboard/list.mit");
			}
		} else { // ��й�ȣ ����ġ �� �޼���
			JSFunction.alertBack(resp, "��й�ȣ�� �߸��Ǿ����ϴ�.");
		}
	}
}