package team.project.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.ReviewDao;
import team.project.vo.ReviewVo;

@WebServlet("/review/review_update")
public class ReviewUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int review_num = Integer.parseInt(req.getParameter("review_num"));
		ReviewDao dao = new ReviewDao();
		ReviewVo vo = dao.getinfo(review_num);
		req.setAttribute("vo", vo);
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/review/review_update.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int review_num = Integer.parseInt(req.getParameter("review_num"));
		int items_num = Integer.parseInt(req.getParameter("items_num"));
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		ReviewVo vo = new ReviewVo(review_num, items_num, id, title, content);
		ReviewDao dao = new ReviewDao();
		int n = dao.update(vo);
		String result = "success";
		if (n <= 0)
			result = "fail";
		req.setAttribute("result", result);
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/review/review_result.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
