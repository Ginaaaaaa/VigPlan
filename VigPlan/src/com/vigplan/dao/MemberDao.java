package com.vigplan.dao;

import com.vigplan.vo.MemberVO;

public class MemberDao extends BaseDao implements IMemberDao {
	public MemberDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
