package team.project.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.ReviewDao;
import team.project.vo.ReviewVo;

@WebServlet("/review/review_detail")
public class ReviewDetail extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int review_num = Integer.parseInt(req.getParameter("review_num"));
		ReviewDao dao = new ReviewDao();
		ReviewVo vo = dao.detail(review_num);
		String content = vo.getContent();
		content = content.replace("\n", "<br>");
		vo.setContent(content);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/review/review_detail.jsp").forward(req, resp);
	}
}