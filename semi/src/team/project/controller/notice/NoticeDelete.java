package team.project.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.NoticeDao;

@WebServlet("/notice/notice_delete")
public class NoticeDelete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		NoticeDao dao = new NoticeDao();
		int n = dao.delete(notice_num);
		String result = "success";
		if (n <= 0)
			result = "fail";
		req.setAttribute("result", result);
		req.getRequestDispatcher("/notice/notice_result.jsp").forward(req, resp);
	}
}
