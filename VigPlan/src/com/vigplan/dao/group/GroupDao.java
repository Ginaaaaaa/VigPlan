package com.vigplan.dao.group;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.vigplan.dao.BaseDao;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MVo;
import com.vigplan.vo.MemberVo;

public class GroupDao extends BaseDao {

	public GroupDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}
	
	
	public List<GroupVo> getMyGroup(Long memberNo) {
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
	
	// gboard list ---멤버 무시하고 전체 그룹 출력하는 메서드라서 안씀
	public List<GroupVo> getAllGboard(){
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
	public int insertGroup(GroupVo vo) {
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
	public Long getGno(GroupVo vo) {
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
	
	
	
	// member group bridge
	public void insertMemberGroupBridge(MemberVo mvo, GroupVo vo) {
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
	
	public int updateGroup(GroupVo vo) {
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
	
	// pw delete check
	public String getGpw(Long gNo) {
		String pw = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = " SELECT gPw FROM gboard WHERE gNo=? ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);	      
	      rs = pstmt.executeQuery();
	      rs.next();
	      pw = rs.getString(1);
	      
	      
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return pw;
	  }
	
	// delete gboard
	public int deleteGroup(Long gNo) {
	    int re = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    String sql = " DELETE FROM gboard WHERE gNo=? ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
	      re = pstmt.executeUpdate();

	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }
	
	
	/*
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

	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }
	*/
	
	// member_group bridge delete
	public int deleteMemberGroupBridge(Long gNo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int re = 0;
	    String sql = " DELETE FROM member_group_bridge WHERE group_gNo=? ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
	      re = pstmt.executeUpdate();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }
		
	
	public int deleteMoimInGroup(Long gNo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int re = 0;
	    String sql = " DELETE FROM mboard WHERE mno IN (SELECT m.mno FROM gboard g, mboard m, group_moim_bridge b WHERE g.gno=? AND b.group_gno=g.gno AND b.moim_mno=m.mno) ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
	      ResultSet rs = pstmt.executeQuery();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	    return re;
	  }
	
	
	// group 삭제 시 moim bridge까지 삭제 
	public void deleteMoimPlaceBridge(Long gNo) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    int re = 0;
	    String sql = " DELETE FROM mboard_place_bridge WHERE mno IN (SELECT m.mno FROM gboard g, mboard m, group_moim_bridge b WHERE g.gno=? AND b.group_gno=g.gno AND b.moim_mno=m.mno) ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
	      ResultSet rs = pstmt.executeQuery();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
	    }
	  }
	
	
	
	// group_moim bridge delete
	public int deleteGroupMoimBridge(Long gNo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int re = 0;	    
	    String sql = " DELETE FROM group_moim_bridge WHERE group_gNo=? ";
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setLong(1, gNo);
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