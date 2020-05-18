package team.project.controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.ReviewDao;
import team.project.vo.ReviewVo;

@WebServlet("/review/review_list")
public class ReviewList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if (spageNum != null)
			pageNum = Integer.parseInt(spageNum);
		int startRow = (pageNum - 1) * 10 + 1;
		int endRow = startRow + 9;

		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewVo> list = dao.list(startRow, endRow);

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
		req.getRequestDispatcher("/review/review_list.jsp").forward(req, resp);
	}
}