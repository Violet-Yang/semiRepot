package team.project.controller.member;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.io.PrintWriter;
import java.util.ArrayList;

import team.project.dao.MemberDao;
import team.project.vo.MemberVo;

@WebServlet("/login.do")
public class MemberLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/login/login_page.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String loginId=req.getParameter("loginId");
		String loginPwd=req.getParameter("loginPwd");
		
		//받아온 아이디 세션에 저장하기
		HttpSession session=req.getSession();
		session.setAttribute("loginId", loginId);
		/*
		HttpSession session=req.getSession();
		session.removeAttribute("loginId");
		*/
		System.out.println(loginId);
		MemberDao dao=new MemberDao();
		MemberVo vo=new MemberVo();
		//getLoginInfo 함수가 실행되면 아이디, 이름, 유저정보가 list형태로 담겨있음
		vo=dao.getLoginInfo(loginId, loginPwd);
		System.out.println("vo찍어보기:"+vo);
		if(vo==null) {
			req.setAttribute("loginError", "다시 로그인해주세영");
			System.out.println("-1까지");
			//resp.setContentType("text/html;charset=utf-8");
			req.setAttribute("top", "/top.jsp");
			req.setAttribute("main", "/login/login_page.jsp");
			req.setAttribute("bot", "/bottom.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else if(vo.getUsertype().equals("user")) {	//사용자 일 때 usertype="user"
			req.setAttribute("usertype","user");
			HttpSession userSession=req.getSession();
			userSession.setAttribute("usertype", "user");
			userSession.setAttribute("id", loginId);
			req.setAttribute("top", "/top.jsp");
			req.setAttribute("main", "/main.jsp");
			req.setAttribute("bot", "/bottom.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
		}else if(vo.getUsertype().equals("admin")) {//관리자 일 때	usertype="admin"
			req.setAttribute("usertype","admin");
			HttpSession userSession=req.getSession();
			userSession.setAttribute("usertype", "admin");
			userSession.setAttribute("id", loginId);
			req.setAttribute("top", "/top.jsp");
			req.setAttribute("main", "/main.jsp");
			req.setAttribute("bot", "/bottom.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
		}
	}
}
