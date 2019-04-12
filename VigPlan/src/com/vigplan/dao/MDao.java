package com.vigplan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.vigplan.vo.MVo;


public class MDao extends BaseDao {

	public MDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}

	
	public List<MVo> getAllmboard(){
		List<MVo> list = new ArrayList<>();
		// DB 로직
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = " SELECT * FROM mboard ";
			rs = stmt.executeQuery(sql);
			
			// ResultSet -> List
			while(rs.next()) {
				MVo vo = new MVo();
				vo.setmTitle(rs.getString(1));
				vo.setmDate(rs.getString(2));
				vo.setmPlace(rs.getString(3));
				vo.setmContent(rs.getString(4));
				
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
	
	
	
	
	
/*	
	// mlist
	public List<MVo> list(int begin, int end){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<MVo> vlist = new ArrayList<MVo>();
	    try {
	    conn = getConnection();
	    String sql = "SELECT * FROM mboard, pos limit ?, ? ";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, begin);
	      pstmt.setInt(2, end);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        MVo vo = new MVo();
	        vo.setmTitle(rs.getString("mTitle"));
	        vo.setmDate(rs.getString("mDate"));
	        vo.setmPlace(rs.getString("mPlace"));
	        vo.setmContent(rs.getString("mContent"));

	        vlist.add(vo);
	        System.out.println("mlist");
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    } 
	    return vlist;
  } 
*/


	
	
	
	// mWrite
	public int insertmBoard(MVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		
		try {
		conn = getConnection();
		String sql = " INSERT INTO mboard VALUES(?, ?, ?, ?) ";
		//	시퀀스 만들고 : 예) 시퀀스 seq_mboard_pk
		//	INSERT INTO mboard VALUES(seq_mboard_pk.nextval, ?, ?, ?, ?)
		//	TODO: sql 디렉터리에 데이터베이스 create 문 넣어 주세요
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getmTitle());
		pstmt.setString(2, vo.getmDate());
		pstmt.setString(3, vo.getmPlace());
		pstmt.setString(4, vo.getmContent());
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

	
	
	// getmboard 
	
	public MVo getmBoard(String mTitle) {
	    MVo vo = new MVo();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    conn = getConnection();
	    String sql = " SELECT * FROM mboard WHERE mTitle=? ";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, mTitle);
	      rs = pstmt.executeQuery();
	      if (rs.next()) {
	        vo.setmTitle(rs.getString("mTitle"));
	        vo.setmDate(rs.getString("mDate"));
	        vo.setmPlace(rs.getString("mPlace"));
	        vo.setmContent(rs.getString("mContent"));
	      } 
	      System.out.println("mgetboard");
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    } 
	    return vo;
	  }

	
	
	// updatemBoard �Խù� ����
	public int updatemBoard(MVo vo) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	      getConnection();
	      String sql = "UPDATE mboard SET mTitle=?, mDate=?, mPlace=?, mContent=?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, vo.getmTitle());
	      pstmt.setString(2, vo.getmDate());
	      pstmt.setString(3, vo.getmPlace());
	      pstmt.setString(4, vo.getmContent());

	      re = pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }



	 // deletemBoard �Խù� ����
	public int deletemBoard(String mTitle) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    String sql = "DELETE FROM board WHERE mTitle=?";
	    try {
	      getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, mTitle);
	      re = pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;

	  }

	
	
	
	
	
}

