package com.vigplan.dao.member;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import com.vigplan.dao.BaseDao;
import com.vigplan.vo.GroupVo;
import com.vigplan.vo.MemberVo;

public class MemberDao extends BaseDao implements IMemberDao {

	public MemberDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}

	// 맨 첫 화면

	public List<MemberVo> getAllLogs() {

		List<MemberVo> list = new ArrayList<>();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "SELECT no, id, pw, nickname, email, reg_date FROM vigteam_member ORDER BY id DESC";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberVo vo = new MemberVo();

				vo.setNo(rs.getLong(1));

				vo.setId(rs.getString(2));

				vo.setPw(rs.getString(3));

				vo.setNickname(rs.getString(4));

				vo.setEmail(rs.getString(5));

				vo.setRegdate(rs.getString(6));

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

	// 저장 메서드

	public int insertMember(MemberVo vo) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		int insertedCount = 0;

		try {

			conn = getConnection();

			String sql = "INSERT INTO member (no, id, pw, nickname, email) VALUES(seq_member_pk.nextval, ? , ? , ? ,? )";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());

			pstmt.setString(2, vo.getPw());

			pstmt.setString(3, vo.getNickname());

			pstmt.setString(4, vo.getEmail());

			insertedCount = pstmt.executeUpdate();

			System.out.println(insertedCount);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

			} catch (Exception e) {

			}

			try {

				if (conn != null)

					conn.close();

			} catch (Exception e) {

			}

		}

		return insertedCount;

	}

	// DB에서 특정 id 정보 가져오는 메소드

	@Override

	public MemberVo getMember(String id, String pw) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		MemberVo line = null;
		
		System.out.println("ID:" + id);
		System.out.println("PASSWORD:" + pw);

		try {

			conn = getConnection();

			String sql = "SELECT no, id, pw, nickname, regdate, email FROM member where id = ? and pw = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
//				System.out.println("RS:" + rs);
			if (rs.next()) {
				line = new MemberVo();
				line.setNo(rs.getLong(1));
				line.setId(id);
				line.setPw(rs.getString(3));
				line.setNickname(rs.getString(4));
				line.setRegdate(rs.getString(5));
				line.setEmail(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

			} catch (Exception e) {

			}

			try {

				if (conn != null)

					conn.close();

			} catch (Exception e) {

			}

		}

		return line;

	}

	// 게시판 내용 수정

	@Override

	public int updateMember(MemberVo vo) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		int result = 0;

		// ResultSet rs = null;

		try {

			conn = getConnection();

			String sql = "UPDATE vigteam_member SET id = ?, pw = ?, nickname = ?, email=? WHERE no = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());

			pstmt.setString(2, vo.getPw());

			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getEmail());
			pstmt.setLong(5, vo.getNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

			} catch (Exception e) {

			}

			try {

				if (conn != null)

					conn.close();

			} catch (Exception e) {

			}

		}

		return result;

	}

	// 게시판 내용 삭제

	@Override

	public int deleteMember(Long no) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			conn = getConnection();

			String sql = "DELETE FROM vigteam_member WHERE no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);

			rs = pstmt.executeQuery();

		} catch (Exception e) {

		} finally {

			try {

				if (pstmt != null)

					pstmt.close();

			} catch (Exception e) {

			}

			try {

				if (conn != null)

					conn.close();

			} catch (Exception e) {

			}

		}

		return 0;

	}
	
	
	// group invite
	public List<MemberVo> getAllinvite(MemberVo mvo, String searchid){
		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = " SELECT * FROM member WHERE id LIKE ? AND id NOT LIKE ? ";
			if(searchid == "") {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			}else {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, "%" + searchid + "%");
			}
			pstmt.setString(2, mvo.getId());

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				MemberVo vo = new MemberVo();
				vo.setNo(rs.getLong("no"));
				vo.setId(rs.getString("id"));
				vo.setNickname(rs.getString("nickname"));
				list.add(vo);
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
		return list;
	}
	
	
	// select 후 memberlist 뽑기
	public List<MemberVo> getMyMember(Long gno){
		List<MemberVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = " SELECT m.no, m.id, m.nickname FROM member m, gboard g, member_group_bridge b WHERE g.gno=? AND m.no = b.member_no AND b.group_gno = g.gNo ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, gno);
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setNo(rs.getLong(1));
				vo.setId(rs.getString(2));
				vo.setNickname(rs.getString(3));
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

}
