package com.vigplan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vigplan.vo.BoardVo;

public class BoardDao extends BaseDao implements IBoardDao {

	public BoardDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);

	}

	// 맨 첫 화면
	public List<BoardVo> getAllLogs() {
		List<BoardVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id, title, writer, content, view_cnt, reg_date FROM vigteam_board ORDER BY id DESC";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setId(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setView_cnt(rs.getLong(5));
				vo.setReg_date(rs.getString(6));
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {

			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}

		}
		return list;
		
	}
	
	//	저장 메서드
	public int insertBoard(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
				conn = getConnection();
				String sql = "INSERT INTO vigteam_board (id, pw, title, writer, content, view_cnt, reg_date) VALUES(seq_brd_pk.nextval, ? , ? , ? ,?, default, sysdate)";
				
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, vo.getPassword());
				pstmt.setString(2, vo.getTitle());
				pstmt.setString(3, vo.getWriter());
				pstmt.setString(4, vo.getContent());

				
				
				insertedCount = pstmt.executeUpdate();
				System.out.println(insertedCount);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
		}
		
		return insertedCount;
		
	}

	//DB에서 특정 id 정보 가져오는 메소드
	@Override
	public BoardVo getBoardItem(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo line = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT title, writer, reg_date, content FROM vigteam_board where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs!=null) {
				
				line = new BoardVo();
				line.setId(id);
				line.setTitle(rs.getString(1));
				line.setWriter(rs.getString(2));
				line.setReg_date(rs.getString(3));
				line.setContent(rs.getString(4));
				
			}
			
		} catch(Exception e){
			
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
			
		}
		return line;
		
	}
		
	//게시판 내용 수정	
	@Override
	public int updateBoard(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		conn = getConnection();
		String sql = "UPDATE vigteam_board SET content = ? WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getContent());
		pstmt.setLong(2, vo.getId());
		rs = pstmt.executeQuery();
		
		
		} catch(Exception e){
			 
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				
			} try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
			
		}
		
		return 0;
	}

	//게시판 내용 삭제
	@Override
	public int deleteBoardItem(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		conn = getConnection();
		String sql = "DELETE FROM vigteam_board WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		rs = pstmt.executeQuery();
		
		
			
		} catch(Exception e){
			 
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				
			} try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
			
		}
		
		return 0;
	}
}
