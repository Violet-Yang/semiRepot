package team.project.controller.detail;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.itemsDetailDao;
import team.project.vo.itemDetailVo;
@WebServlet("/detail.do")
public class DetailShow extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int itemNum = Integer.parseInt(req.getParameter("itemNum"));
		itemsDetailDao dao = new itemsDetailDao();
		ArrayList<itemDetailVo> imgList = dao.getImg(itemNum);
		ArrayList<itemDetailVo> optionList = dao.getOption(itemNum);
		req.setAttribute("imgList", imgList);
		req.setAttribute("optionList", optionList);
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/detail.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
