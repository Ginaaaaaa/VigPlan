package com.vigplan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vigplan.vo.BoardVo;

public class BoardDao extends BaseDao {

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
			String sql = "SELECT id, title, writer, content, view_cnt, reg_date FROM vigteam_board";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setId(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setView_cnt(rs.getInt(5));
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
				String sql = "INSERT INTO vigteam_board VALUES(seq_log_pk.nextval, ? , ? , ? , ? , default , default )";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, vo.getId());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getTitle());
				pstmt.setString(4, vo.getWriter());
				pstmt.setString(5, vo.getContent());
				pstmt.setInt(6,vo.getView_cnt());
				pstmt.setString(7, vo.getReg_date());
				
				insertedCount = pstmt.executeUpdate();
				
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
		//	TODO: 데이터베이스에 BoardVo(vo) 저장
		return insertedCount;
	}
}
