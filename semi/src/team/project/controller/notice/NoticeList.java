package team.project.controller.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.NoticeDao;
import team.project.vo.NoticeVo;

@WebServlet("/notice/notice_list")
public class NoticeList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if (spageNum != null)
			pageNum = Integer.parseInt(spageNum);
		int startRow = (pageNum - 1) * 10 + 1;
		int endRow = startRow + 9;

		NoticeDao dao = new NoticeDao();
		ArrayList<NoticeVo> list = dao.list(startRow, endRow);

		int pageCount = (int) Math.ceil(dao.getCount() / 10.0);
		int startPageNum = ((pageNum - 1) / 10) * 10 + 1;
		int endPageNum = startPageNum + 9;
		if (pageCount < endPageNum)
			endPageNum = pageCount;

		req.setAttribute("pageNum", pageNum);
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/notice/notice_list.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
