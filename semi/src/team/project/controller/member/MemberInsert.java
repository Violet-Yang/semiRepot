package team.project.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team.project.vo.MemberVo;
import team.project.dao.*;

@WebServlet("/joinOk.do")
public class MemberInsert extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String pwd2=req.getParameter("pwd2");
		String name=req.getParameter("name");
		int birth=Integer.parseInt(req.getParameter("birth"));
		String gender=req.getParameter("gender");
		String addr=req.getParameter("addr");
		int phone=Integer.parseInt(req.getParameter("phone"));
		String email=req.getParameter("email");
		MemberVo vo=new MemberVo(id, pwd, name, addr, birth, phone, gender, email, null,null);
		MemberDao dao= new MemberDao();
		int n=dao.insertMemberInfo(vo);
		if(n>0) {
			req.setAttribute("msg", "success");
		}else {
			req.setAttribute("msg", "fail");
		}
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/join/joinOk.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/join/join.html");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
