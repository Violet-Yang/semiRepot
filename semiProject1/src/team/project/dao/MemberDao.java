package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import team.project.db.util.JDBCUtil;
import team.project.vo.MemberVo;

public class MemberDao {

	// 회원가입버튼 누르면 실행되는 메서드
	public int insertMemberInfo(MemberVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,sysdate,'user')";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddr());
			pstmt.setInt(5, vo.getDate_of_birth());
			pstmt.setInt(6, vo.getPhone());
			pstmt.setString(7, vo.getGender());
			pstmt.setString(8, vo.getEmail());
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}

	}

	// 아이디 중복확인 누르면 실행되는 메서드 - member테이블에서 조회실행
	public int checkDupId(String member_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from member where id=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			return pstmt.executeUpdate();
			// 아이디가 존재하면 return에 1이 담겨있는 상태
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}

	// 로그인 버튼 누르면 실행
	public int goLogin(String loginId, String loginPwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, pwd, usertype from member where id=? and pwd=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1;
			}
			return -1;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}

	// 로그인 버튼 누르면 회원의 아이디, 이름, 유저타입 뽑아옴
	public MemberVo getLoginInfo(String loginId, String loginPwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=? and pwd=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String usertype = rs.getString("usertype");
				MemberVo vo = new MemberVo(id, pwd, name, null, 0, 0, null, null, null, usertype);
				return vo;
			}
			return null;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}

	public int checkemail(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select email from member where email=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1; // 1이면 이메일 중복
			}
			return -1;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}

	// 유저아이디중복검사 메소드
	public int userIdcheck(String member_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from member where id=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1; // 1이면 아이디 중복
			}
			return 2;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}

	// 마이페이지-회원정보 -회원정보 수정 li 눌렀을 때 메서드
	public MemberVo getMemberInfo(String loginId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				int date_of_birth = Integer.parseInt(rs.getString("date_of_birth"));
				int phone = Integer.parseInt(rs.getString("phone"));
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String regdate = rs.getString("regdate");
				MemberVo vo = new MemberVo(id, null, name, addr, date_of_birth, phone, gender, email, regdate, null);
				return vo;
			}
			return null;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	
	/*
	// 회원정보수정 li에서 테이터 바꾼 후 수정 버튼 눌렀을 때 메서드
	public MemberVo updateMemberInfo(String loginId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "update member set pwd=?, addr=?, phone=?, email=? where id=?";
		con=JDBCUtil.getConn();
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, vo.get);
		psmt
	}
	*/
}
