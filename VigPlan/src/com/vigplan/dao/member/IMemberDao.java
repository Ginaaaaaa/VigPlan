package com.vigplan.dao.member;

import com.vigplan.vo.MemberVo;

public interface IMemberDao {
	public int insertMember(MemberVo vo);
	public MemberVo getMember(String id, String password);
	int updateMember(MemberVo vo);
	int deleteMember(Long no);
}
