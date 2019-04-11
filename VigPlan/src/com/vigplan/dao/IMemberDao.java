package com.vigplan.dao;

import com.vigplan.vo.MemberVO;

public interface IMemberDao {
	public int insertMember(MemberVO vo);
	public MemberVO getMember(String id, String password);
}
