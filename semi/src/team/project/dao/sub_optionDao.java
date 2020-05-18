package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import team.project.db.util.JDBCUtil;
import team.project.vo.item_optionVo;
import team.project.vo.sub_optionVo;

public class sub_optionDao {
	public int insert(sub_optionVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("insert into sub_option values(sub_option_seq.nextval,?,?,?)");
			pstmt.setInt(1,vo.getOption_num());
			pstmt.setString(2,vo.getColor());
			pstmt.setInt(3,vo.getCount());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
}
