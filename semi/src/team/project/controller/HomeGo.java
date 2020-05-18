package team.project.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class HomeGo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String top = req.getParameter("top");
		String main = req.getParameter("main");
		String bot =  req.getParameter("bot");
		String contextPath = req.getContextPath();
		ServletContext application = req.getServletContext();
		application.setAttribute("cp", contextPath);    
		if(top==null) {
			top = "/top.jsp";
		}
		if(main==null) {
			main = "/main.jsp";
		}
		if(bot==null) {
			bot = "/bottom.jsp";
		}
		application.setAttribute("cp", contextPath);
		req.setAttribute("top", top);
		req.setAttribute("main", main);
		req.setAttribute("bot", bot);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}