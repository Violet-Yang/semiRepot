package team.project.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import team.project.dao.ReviewDao;
import team.project.dao.Review_imgDao;
import team.project.vo.ReviewVo;
import team.project.vo.Review_imgVo;

@WebServlet("/review/review_insert")
public class ReviewInsert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/review/review_insert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String reviewUpload = req.getServletContext().getRealPath("/reviewUpload");
		MultipartRequest mr = new MultipartRequest(req, reviewUpload, 1025 * 1024 * 5, "utf-8",
				new DefaultFileRenamePolicy());
		int items_num = Integer.parseInt(mr.getParameter("items_num"));
		String id = mr.getParameter("id");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String file_name = mr.getOriginalFileName("FileName");
		String file_type = mr.getFilesystemName("FileName");
		ReviewDao reDao = new ReviewDao();
		Review_imgDao imgDao = new Review_imgDao();

		ReviewVo reVo = new ReviewVo(0, items_num, id, title, content);
		reDao.insert(reVo);
		int review_num = reDao.getNum();
		
		Review_imgVo imgVo = new Review_imgVo(0, (review_num - 1), file_name, file_type);
		imgDao.insert(imgVo);

		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/review/review_list.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}