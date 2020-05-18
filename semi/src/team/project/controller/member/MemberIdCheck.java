package team.project.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.controller.member.*;
import team.project.dao.MemberDao;
@WebServlet("/idcheck.do")
public class MemberIdCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//id파라미터 받아오기
		String id=req.getParameter("id");
		System.out.println(id);
		//아이디에 특수문자 포함되어있는지,4글자 이상 12글자 이하인지 확인
		boolean ckstr = Pattern.matches("^[a-zA-Z0-9]{4,12}$", id);
		if (ckstr==true) {
			req.setAttribute("ckstr", ckstr);
		}else {
			req.setAttribute("ckstr", ckstr);
		}
		     
		//유저테이블 id 조회
		MemberDao dao=new MemberDao();
		boolean using=false;
		int n1 = dao.userIdcheck(id);
		if(n1==1) {
			//중복된 아이디
			using=true;
			req.setAttribute("using", using);
		}else if(n1==2){
			//사용가능한 아이디
			req.setAttribute("using", using);
		}
		
		//xml형식으로 전달 ajax
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.print("<using>" + using +"</using>");
		pw.print("<ckstr>" + ckstr +"</ckstr>");
		pw.print("</result>");
		//http://localhost:9090/ajax02/1/idcheck.jsp?id=aaa
	}
}
