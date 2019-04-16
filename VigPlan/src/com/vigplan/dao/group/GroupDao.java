package com.vigplan.dao.group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.vigplan.dao.BaseDao;
import com.vigplan.vo.GroupVo;

public class GroupDao extends BaseDao {

	public GroupDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}
	
	
	// gboard list
	
	public List<GroupVo> getAllgboard(){
		List<GroupVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = " SELECT * FROM gboard ";
			rs = stmt.executeQuery(sql);
			
			// ResultSet -> List
			while(rs.next()) {
				GroupVo vo = new GroupVo();
				vo.setgNo(rs.getLong(1));
				vo.setgName(rs.getString(2));
				vo.setgRegdate(rs.getString(3));
				vo.setgPw(rs.getString(4));
			
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (Exception e) {}
			try {
				if (stmt != null) stmt.close();
			} catch (Exception e) {}
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	
	
	
	//gboard write
	public int insertgboard(GroupVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		
		try {
			conn = getConnection();
			String sql = " INSERT INTO gboard VALUES(seq_gboard_pk.nextval, ?, sysdate, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getgName());
			pstmt.setString(2, vo.getgPw());
			rs = pstmt.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
		return i;
	}
	
	
	
}