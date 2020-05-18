package team.project.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.*;
@WebServlet("/emailcheck.do")
public class MemberEmailCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		System.out.println(email);
		boolean mailusing=false;
		//중복검사 dao
		MemberDao dao=new MemberDao();
		int n=dao.checkemail(email);
		if(n>0) {
			mailusing=true;
			req.setAttribute("mailusing", mailusing);
		}else {
			req.setAttribute("mailusing", mailusing);
		}
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.print("<mailusing>" + mailusing +"</mailusing>");
		pw.print("</result>");
	}
}
