package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import team.project.db.util.JDBCUtil;
import team.project.vo.main_categoryVo;

public class main_categoryDao {
	public int insert(main_categoryVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("insert into main_category values(main_category_seq.nextval,?,?)");
			pstmt.setInt(1,vo.getPre_category_num());
			pstmt.setString(2,vo.getName());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	public int getNum(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			pstmt=con.prepareStatement("select main_category_num from main_category where name = ?");
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
}
