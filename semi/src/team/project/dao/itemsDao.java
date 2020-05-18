package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.project.db.util.JDBCUtil;
import team.project.vo.itemsVo;
import team.project.vo.main_categoryVo;

public class itemsDao {
	public int insert(itemsVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("insert into items values(items_seq.nextval,?,?,?,?,TO_CHAR(sysdate,'yyyy/mm/dd hh24:mi:ss'))");
			pstmt.setInt(1,vo.getMain_category_num());
			pstmt.setString(2,vo.getName());
			pstmt.setInt(3,vo.getPrice());
			pstmt.setString(4,vo.getInfo());
			pstmt.executeUpdate();
			return vo.getItems_num();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	public int getNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			pstmt=con.prepareStatement("select items_seq.nextval from dual");
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
	public ArrayList<itemsVo> list(int startRow,int endRow, int preNum,int mainNum) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<itemsVo> list = new ArrayList<itemsVo>();
		String sql = null;
		try {
			con = JDBCUtil.getConn();
			if(mainNum!=0) {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m where m.pre_category_num = ? and m.main_category_num = ? and i.main_category_num= ? )"
						+ " aa) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, mainNum);
				pstmt.setInt(3, mainNum);
				pstmt.setInt(4, startRow);
				pstmt.setInt(5, endRow);
			}else {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m "
						+ "where m.pre_category_num = ? and "
						+ "i.main_category_num = m.main_category_num) "
						+ "aa) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				itemsVo vo = new itemsVo(rs.getInt("items_num"),
						rs.getInt("cn"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("info"),
						rs.getString("item_date"));
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
	
	public ArrayList<itemsVo> newList(int preNum,int mainNum) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<itemsVo> list = new ArrayList<itemsVo>();
		String sql = null;
		try {
			con = JDBCUtil.getConn();
			if(mainNum!=0) {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m where m.pre_category_num = ? and i.main_category_num = ? and m.main_category_num = ? order by i.item_date desc)"
						+ " aa) where rnum>=1 and rnum<=4";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, mainNum);
				pstmt.setInt(3, mainNum);
			}else {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m "
						+ "where m.pre_category_num = ? and i.main_category_num = m.main_category_num order by i.item_date desc) "
						+ "aa) where rnum>=1 and rnum<=4";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				itemsVo vo = new itemsVo(rs.getInt("items_num"),
						rs.getInt("cn"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("info"),
						rs.getString("item_date"));
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
	
	public ArrayList<itemsVo> priceHighList(int startRow,int endRow,int preNum,int mainNum) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<itemsVo> list = new ArrayList<itemsVo>();
		String sql = null;
		try {
			con = JDBCUtil.getConn();
			if(mainNum!=0) {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m where m.pre_category_num = ? and i.main_category_num = ? and m.main_category_num = ? order by i.price desc)"
						+ " aa) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, mainNum);
				pstmt.setInt(3, mainNum);
				pstmt.setInt(4, startRow);
				pstmt.setInt(5, endRow);
			}else {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m "
						+ "where m.pre_category_num = ? and i.main_category_num = m.main_category_num order by i.price desc) "
						+ "aa) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				itemsVo vo = new itemsVo(rs.getInt("items_num"),
						rs.getInt("cn"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("info"),
						rs.getString("item_date"));
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
	
	public ArrayList<itemsVo> priceRowList(int startRow,int endRow,int preNum,int mainNum) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<itemsVo> list = new ArrayList<itemsVo>();
		String sql = null;
		try {
			con = JDBCUtil.getConn();
			if(mainNum!=0) {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m where m.pre_category_num = ? and i.main_category_num = ? and m.main_category_num = ? order by i.price asc)"
						+ " aa) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, mainNum);
				pstmt.setInt(3, mainNum);
				pstmt.setInt(4, startRow);
				pstmt.setInt(5, endRow);
			}else {
				sql = "select * from (select aa.*,rownum rnum from "
						+ "(select i.items_num,i.main_category_num cn,i.name,i.price,i.info,i.item_date "
						+ "from items i,main_category m "
						+ "where m.pre_category_num = ? and i.main_category_num = m.main_category_num order by i.price asc) "
						+ "aa) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, preNum);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				itemsVo vo = new itemsVo(rs.getInt("items_num"),
						rs.getInt("cn"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("info"),
						rs.getString("item_date"));
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
	
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt=  null;
		ResultSet rs =null;
		try {
			con=JDBCUtil.getConn();
			String sql = "select NVL(count(items_num),0) cnt from items";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}else {
				return 0;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
}
