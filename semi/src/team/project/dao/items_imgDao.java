package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.project.db.util.JDBCUtil;
import team.project.vo.item_optionVo;
import team.project.vo.items_imgVo;

public class items_imgDao {
	public int insert(items_imgVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("insert into items_img values(items_img_seq.nextval,?,?,?)");
			pstmt.setInt(1,vo.getItems_num());
			pstmt.setString(2,vo.getFile_name());
			pstmt.setString(3,vo.getFile_type());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	
	public items_imgVo list(int items_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		items_imgVo vo = null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("select * from items_img where items_num = ?");
			pstmt.setInt(1, items_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo = new items_imgVo(rs.getInt("items_img_num"), 
						items_num, 
						rs.getString("file_name"), 
						rs.getString("file_type"));
			}
			return vo;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	public int getNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			pstmt=con.prepareStatement("select items_img_seq.nextval from dual");
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
