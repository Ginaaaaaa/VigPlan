package com.vigplan.dao.moim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vigplan.dao.BaseDao;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MVo;
import com.vigplan.vo.MemberVo;


public class MDao extends BaseDao {

	public MDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}

	
	public List<MVo> getAllMoim(){
		List<MVo> list = new ArrayList<>();
		// DB 로직
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = " SELECT * FROM mboard ORDER BY mDate";
			rs = stmt.executeQuery(sql);
			
			// ResultSet -> List
			while(rs.next()) {
				MVo vo = new MVo();
				vo.setmNo(rs.getLong(1));
				vo.setmTitle(rs.getString(2));
				vo.setmDate(rs.getString(3));
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
	
	
	// select mboard
	public MVo selectOne(Long mNo) {
		MVo moim = null;
		//	TODO: mNo로 모임 한 개 가져오기
		Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	      conn = getConnection();
	      String sql = "SELECT * FROM mboard WHERE mNo =?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, mNo);
	      ResultSet rs = pstmt.executeQuery();
	     
	      if (rs.next()) {
	    	  moim = new MVo();
	    	  moim.setmNo(rs.getLong("mNo"));
	    	  moim.setmTitle(rs.getString("mTitle"));
	    	  moim.setmDate(rs.getString("mDate"));
	    	  moim.setmContent(rs.getString("mContent"));
	              }
	    }catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if(conn != null) conn.close();} catch(Exception e) {}
			}

		
		return moim;
	}

	
	// group moim bridge
	public void insertGroupMoimbridge(GroupVo gvo, MVo mvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = " INSERT INTO group_moim_bridge VALUES(?, (SELECT MAX(mno) FROM mboard)) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, gvo.getgNo());
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
	}
	
	
	// group 내 moim 불러오기
	public List<MVo> getMyMoim(Long gno){
		List<MVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = " SELECT m.mno, m.mtitle, m.mdate FROM gboard g, mboard m, group_moim_bridge b WHERE g.gno=? AND b.group_gno = g.gNo AND m.mno = b.moim_mno ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, gno);
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
				MVo vo = new MVo();
				vo.setmNo(rs.getLong(1));
				vo.setmTitle(rs.getString(2));
				vo.setmDate(rs.getString(3));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
		return list;
	}
	
	
	
	// mWrite
	public int insertMoim(MVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		
		try {
		conn = getConnection();
		String sql = " INSERT INTO mboard VALUES(seq_mboard_pk.nextval, ?, ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getmTitle());
		pstmt.setString(2, vo.getmDate());
		pstmt.setString(3, vo.getmContent());
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


	
	
	// updatemBoard 
	public int updateMoim(Long mNo, String mTitle, String mDate, String mContent) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	      conn = getConnection();
	      String sql = "UPDATE mboard SET mTitle=?, mDate=?, mContent=? WHERE mNo=?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, mTitle);
	      pstmt.setString(2, mDate);
	      pstmt.setString(3, mContent);
	      pstmt.setLong(4, mNo);
	      System.out.println("updatemboard");
	      re = pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }



	 // deletemBoard 
	public int deleteMoim(Long mNo) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    String sql = "DELETE FROM mboard WHERE mNo=?";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, mNo);
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

