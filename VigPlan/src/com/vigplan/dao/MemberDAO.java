package com.vigplan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.sql.DataSource;

import com.vigplan.vo.MemberVO;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int insertMember(MemberVO vo) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into users values (?,?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2,  vo.getPw());
			pstmt.setString(3,  vo.getName());
			pstmt.setString(4,  vo.geteMail());
			pstmt.setString(5,  vo.getrDate());
			pstmt.executeUpdate();
			ri = MemberDAO.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from users where id = ?"; // 회원가입 시 존재하는 ID인지 확인, 
															// 그 후 id 검색되면 75line의 set.next()를 사용
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,  id);
			set = pstmt.executeQuery();
			if(set.next()) {
				ri = MemberDAO.MEMBER_EXISTENT;
			} else {
				ri = MemberDAO.MEMBER_NONEXISTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from users where id = ?";	// 회원가입 시 존재하는 ID인지 확인, 
														   	// 그 후 id 검색되면 75line의 set.next()를 사용
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dbPw = set.getString("pw");
				if(dbPw.equals(pw)) {
					ri = MemberDAO.MEMBER_LOGIN_SUCCESS;		// 로그인 ok
				} else {
					ri = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;		// 비번 x
				}
			} else {
				ri = MemberDAO.MEMBER_LOGIN_IS_NOT;				// 회원 x
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public MemberVO getMember(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from users where id = ?";
		MemberVO vo = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt = setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				vo = new MemberVO();
				vo.setId(set.getString("id"));
				vo.setPw(set.getString("pw"));
				vo.setName(set.getString("name"));
				vo.seteMail(set.getString("eMail"));
				vo.setrDate(set.getString("rDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public int updateMember (MemberVO vo) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "update users set pw=?, eMail=?, where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.geteMail());
			pstmt.setString(3, vo.getId());
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	private Connection getConnection() {
		
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		try{
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle12c");
		connection = dataSource.getConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return connection;
}

}






