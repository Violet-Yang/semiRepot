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
@WebServlet("/memberInfoUpdate.do")
public class MemberInfoUpdate extends HttpServlet{
	
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
		MemberDao dao=new MemberDao();
		HttpSession session=req.getSession();
		String loginId=(String)session.getAttribute("loginId");
		System.out.println("여기는 멤버인포업데이트서블릿"+loginId);
		MemberVo UpdatedInfovo=new MemberVo();
		//UpdatedInfovo.updateMemberInfo(String loginId);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String loginId=(String)session.getAttribute("loginId");
		
		MemberDao dao=new MemberDao();
		MemberVo voInfo=new MemberVo();
		//아이디를 보내면 전체 회원정보가 vo객체에 담김
		voInfo=dao.getMemberInfo(loginId);
		req.setAttribute("voInfo", voInfo);
		req.getRequestDispatcher("/mypage/mypage_memberInfoOk.jsp").forward(req, resp);
	}
}
