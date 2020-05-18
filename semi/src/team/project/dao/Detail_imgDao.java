package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import team.project.db.util.JDBCUtil;
import team.project.vo.Detail_imgVo;

public class Detail_imgDao {
	public int insert(Detail_imgVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("insert into detail_img values(detail_img_seq.nextval,?,?,?)");
			pstmt.setInt(1 , vo.getItems_img_num());
			pstmt.setString(2, vo.getFile_name());
			pstmt.setString(3, vo.getFile_type());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally { 
			JDBCUtil.close(null,pstmt,con);    
		}      
	}
}
