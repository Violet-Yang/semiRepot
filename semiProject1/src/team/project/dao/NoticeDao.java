package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.project.db.util.JDBCUtil;
import team.project.vo.NoticeVo;

public class NoticeDao {
	// 가장 큰 글번호 (페이징처리)
	public int getCount() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(notice_num), 0) cnt from notice";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			} else {
				return 0;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 선택조회 (수정하기 위한)
	public NoticeVo getinfo(int notice_num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from notice where notice_num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, notice_num);
			rs = pst.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				NoticeVo vo = new NoticeVo(notice_num, id, title, content);
				return vo;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 추가
	public int insert(NoticeVo vo) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into notice values(NOTICE_SEQ.nextval, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getTitle());
			pst.setString(3, vo.getContent());
			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	// 목록
	public ArrayList<NoticeVo> list(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from "
					+ "(select aa.*, rownum rnum from "
					+ "(select * from notice order by notice_num desc) aa) "
					+ "where rnum>=? and rnum<=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			rs = pst.executeQuery();
			while (rs.next()) {
				int notice_num = rs.getInt("notice_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				NoticeVo vo = new NoticeVo(notice_num, id, title, content);
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 상세조회
	public NoticeVo detail(int notice_num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from notice where notice_num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, notice_num);
			rs = pst.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				NoticeVo vo = new NoticeVo(notice_num, id, title, content);
				return vo;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 수정
	public int update(NoticeVo vo) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update notice set title=?, content=? where notice_num=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContent());
			pst.setInt(3, vo.getNotice_num());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	// 삭제
	public int delete(int notice_num) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from notice where notice_num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, notice_num);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}
}
