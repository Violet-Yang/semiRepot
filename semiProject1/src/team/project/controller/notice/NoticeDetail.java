package team.project.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.NoticeDao;
import team.project.vo.NoticeVo;

@WebServlet("/notice/notice_detail")
public class NoticeDetail extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		NoticeDao dao = new NoticeDao();
		NoticeVo vo = dao.detail(notice_num);
		String content = vo.getContent();
		content = content.replace("\n", "<br>");
		vo.setContent(content);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/notice/notice_detail.jsp").forward(req, resp);
	}
}