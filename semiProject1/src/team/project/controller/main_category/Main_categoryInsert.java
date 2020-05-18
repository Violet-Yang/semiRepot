package team.project.controller.main_category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.main_categoryDao;
import team.project.vo.main_categoryVo;

@WebServlet("/categoryInsert")
public class Main_categoryInsert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/categoryEnroll.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String preCategoryNum = req.getParameter("preCategoryNum");
		String name = req.getParameter("name");
		main_categoryDao dao = new main_categoryDao();
		dao.insert(new main_categoryVo(0,Integer.parseInt(preCategoryNum),name));
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/main.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
