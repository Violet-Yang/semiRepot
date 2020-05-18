package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import team.project.db.util.JDBCUtil;
import team.project.vo.NoticeVo;
import team.project.vo.ReviewVo;

public class ReviewDao {
	// 글목록의 개수 (페이징처리)
	public int getCount() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(count(*), 0) cnt from review";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 선택조회(수정)
	public ReviewVo getinfo(int review_num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from review where review_num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, review_num);
			rs = pst.executeQuery();
			if (rs.next()) {
				int items_num = rs.getInt("items_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				ReviewVo vo = new ReviewVo(review_num, items_num, id, title, content);
				return vo;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getNum() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select review_seq.nextval from dual";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 리뷰추가
	public int insert(ReviewVo vo) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into review values(review_seq.nextval, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, vo.getItems_num());
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getTitle());
			pst.setString(4, vo.getContent());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	// 리뷰목록
	public ArrayList<ReviewVo> list(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from " + "(select aa.*, rownum rnum from "
					+ "(select * from review order by review_num desc) aa) " + "where rnum>=? and rnum<=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			rs = pst.executeQuery();
			while (rs.next()) {
				int review_num = rs.getInt("review_num");
				int items_num = rs.getInt("items_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				ReviewVo vo = new ReviewVo(review_num, items_num, id, title, content);
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
	public ReviewVo detail(int review_num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from review where review_num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, review_num);
			rs = pst.executeQuery();
			if (rs.next()) {
				int items_num = rs.getInt("items_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				ReviewVo vo = new ReviewVo(review_num, items_num, id, title, content);
				return vo;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 수정
	public int update(ReviewVo vo) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update review set title=?, content=? where review_num=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContent());
			pst.setInt(3, vo.getReview_num());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	// 삭제
	public int delete(int review_num) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		try {
			con = JDBCUtil.getConn();
			// 자식 테이블
			String sql1 = "delete from review_img where review_num=?";
			pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, review_num);
			pst1.executeUpdate();

			// 부모 테이블
			String sql2 = "delete from review where review_num=?";
			pst2 = con.prepareStatement(sql2);
			pst2.setInt(1, review_num);
			return pst2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (pst1 != null)
					pst1.close();
				if (pst2 != null)
					pst2.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}