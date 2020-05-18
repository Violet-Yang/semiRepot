package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import team.project.db.util.JDBCUtil;
import team.project.vo.Review_imgVo;

public class Review_imgDao {
	public int insert(Review_imgVo vo) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into review_img values(review_img_seq.nextval, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, vo.getReview_num());
			pst.setString(2, vo.getFile_name());
			pst.setString(3, vo.getFile_type());
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	public Review_imgVo list(int review_num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from review_img where review_num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, review_num);
			if (rs.next()) {
				int re_img_num = rs.getInt("re_img_num");
				String file_name = rs.getString("file_name");
				String file_type = rs.getString("file_type");
				Review_imgVo vo = new Review_imgVo(re_img_num, review_num, file_name, file_type);
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
}
