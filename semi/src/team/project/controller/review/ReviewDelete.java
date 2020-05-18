package team.project.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.ReviewDao;

@WebServlet("/review/review_delete")
public class ReviewDelete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int review_num = Integer.parseInt(req.getParameter("review_num"));
		ReviewDao dao = new ReviewDao();
		int n = dao.delete(review_num);
		String result = "success";
		if (n <= 0)
			result = "fail";
		req.setAttribute("result", result);
		req.getRequestDispatcher("/review/review_result.jsp").forward(req, resp);
	}
}