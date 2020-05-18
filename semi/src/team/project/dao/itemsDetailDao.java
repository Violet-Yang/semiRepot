package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.project.db.util.JDBCUtil;
import team.project.vo.itemDetailVo;

public class itemsDetailDao {
	public ArrayList<itemDetailVo> getImg(int items_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select i.name,i.price,i.info,m.file_type mimg,d.file_type simg \r\n" + 
				"from items i ,items_img m, detail_img d\r\n" + 
				"where m.items_img_num = d.items_img_num\r\n" + 
				"and i.items_num = ? and m.items_num = i.items_num";
		ArrayList<itemDetailVo> list = new ArrayList<itemDetailVo>();
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, items_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				itemDetailVo vo = new itemDetailVo(rs.getString(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),null,null,0);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	
	public ArrayList<itemDetailVo> getOption(int items_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select o.item_size,so.color,so.count\r\n" + 
				"from items i,item_option o,sub_option so\r\n" + 
				"where i.items_num = ? and o.items_num = i.items_num "
				+ "and so.option_num = o.option_num;";
		ArrayList<itemDetailVo> list = new ArrayList<itemDetailVo>();
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, items_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				itemDetailVo vo = new itemDetailVo(null,
						0,
						null,
						null,
						null,rs.getString(1),rs.getString(2),rs.getInt(3));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
}
