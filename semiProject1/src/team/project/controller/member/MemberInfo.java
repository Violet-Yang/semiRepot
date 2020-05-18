package team.project.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.project.dao.MemberDao;
import team.project.vo.MemberVo;
@WebServlet("/memberInfo.do")
public class MemberInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao dao=new MemberDao();
		HttpSession session=req.getSession();
		String loginId=(String)session.getAttribute("loginId");
		System.out.println(loginId);
		MemberVo memberInfovo=new MemberVo();
		//getMemberInfo함수가 실행되면 아이디에 따른 모든 회원 정보를 담은 memberInfoVo
		memberInfovo=dao.getMemberInfo(loginId);
		req.setAttribute("vo", memberInfovo);
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/mypage/mypage_fst_memberInfo.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
