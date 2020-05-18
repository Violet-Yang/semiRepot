package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.project.db.util.JDBCUtil;
import team.project.vo.Review_commentVo;

public class Review_commentDao {

	// ¸ñ·Ï
	public ArrayList<Review_commentVo> list() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Review_commentVo> list = new ArrayList<Review_commentVo>();
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from review_comment order by desc";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int comm_num = rs.getInt("comm_num");
				int review_num = rs.getInt("review_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Review_commentVo vo = new Review_commentVo(comm_num, review_num, id, title, content);
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
}