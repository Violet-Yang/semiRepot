package team.project.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.NoticeDao;
import team.project.vo.NoticeVo;

@WebServlet("/notice/notice_update")
public class NoticeUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		NoticeDao dao = new NoticeDao();
		NoticeVo vo = dao.getinfo(notice_num);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/notice/notice_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		NoticeVo vo = new NoticeVo(notice_num, id, title, content);
		NoticeDao dao = new NoticeDao();
		int n = dao.update(vo);
		String result = "success";
		if (n <= 0)
			result = "fail";
		req.setAttribute("result", result);
		req.getRequestDispatcher("/notice/notice_result.jsp").forward(req, resp);
	}
}
