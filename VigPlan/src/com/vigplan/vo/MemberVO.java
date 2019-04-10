package com.vigplan.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberVO {
	private String name;
	private String id;
	private String pw;
	private String eMail;

	public MemberVO() {
		super();
	}
	
	public MemberVO(String name, String id, String pw, String eMail) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.eMail = eMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/*
	public int updateMember(MemberVO vo) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "update users set pw=?, eMail=?, address=? where id=?";

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
	*/
}