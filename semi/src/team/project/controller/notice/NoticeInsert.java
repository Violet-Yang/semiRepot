package team.project.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.NoticeDao;
import team.project.vo.NoticeVo;

@WebServlet("/notice/notice_insert")
public class NoticeInsert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/notice/notice_insert.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		NoticeVo vo = new NoticeVo(0, id, title, content);
		NoticeDao dao = new NoticeDao();
		dao.insert(vo);
		
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/notice/notice_list.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}