package com.vigplan.dao.group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.vigplan.dao.BaseDao;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;

public class GroupDao extends BaseDao {

	public GroupDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}
	
	
	public List<GroupVo> getMyGboard(Long memberNo) {
		List<GroupVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = " SELECT g.gNo, g.gName, g.gRegdate FROM member m, gboard g, member_group_bridge b WHERE m.no=? AND b.member_no = m.no AND b.group_gno = g.gNo ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, memberNo);
		    rs = pstmt.executeQuery();
			
		    while(rs.next()) {
				GroupVo vo = new GroupVo();
				vo.setgNo(rs.getLong(1));
				vo.setgName(rs.getString(2));
				vo.setgRegdate(rs.getString(3));
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
	
	
	//gboard select
	public GroupVo selectOne(Long gNo) {
		GroupVo group = null;
		//	TODO: mNo로 모임 한 개 가져오기
		Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	      conn = getConnection();
	      String sql = "SELECT * FROM gboard WHERE gNo =?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
	      ResultSet rs = pstmt.executeQuery();
	     
	      if (rs.next()) {
	    	  group = new GroupVo();
	    	  group.setgNo(rs.getLong("gNo"));
	    	  group.setgName(rs.getString("gName"));
	    	  group.setgRegdate(rs.getString("gRegdate"));
	    	  group.setgPw(rs.getString("gPw"));
	              }
	    }catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
				try {if(conn != null) conn.close();} catch(Exception e) {}
			}
		return group;
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
	
	
	// gno 뽑아오는 메서드
	public Long getgNo(GroupVo vo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Long maxno = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = " SELECT MAX(gno) FROM gboard ";
			rs = stmt.executeQuery(sql);
			rs.next();
			maxno = rs.getLong(1);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
		return maxno;
	}
	
	
	
	// member gboard bridge
	public void insertbridge(MemberVo mvo, GroupVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = " INSERT INTO member_group_bridge VALUES(?, (SELECT MAX(gno) FROM gboard)) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, mvo.getNo());
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
	}
	
	
	
	
	
	//gboard update
	
	public int updategBoard(GroupVo vo) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	      conn = getConnection();
	      String sql = " UPDATE gboard SET gName=? WHERE gNo=? ";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, vo.getgName());
	      pstmt.setLong(2, vo.getgNo());
	      System.out.println("updategboard");
	      re = pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }
	
	
	// gboard delete
	public int deletegBoard(Long gNo, String pw) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    String sql = " DELETE FROM gboard WHERE gNo=? AND gPw=? ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
	      pstmt.setString(2, pw);
	      re = pstmt.executeUpdate();
	      if(re == 1) { 	// 1이면 성공
	    	  
	      } else {			// 0이면 실패
	    	  
	      }
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }
	
	
	// bridge delete
	
}