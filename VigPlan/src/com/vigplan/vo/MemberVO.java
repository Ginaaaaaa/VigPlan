package com.vigplan.vo;

public class MemberVO {
	private String id;
	private String password;
	private String nickName;
	private String eMail;
	private String rDate;

	public MemberVO() {

	}

	public MemberVO(String id, String password, String nickName, String eMail, String rDate) {
		this.id = id;
		this.password = password;
		this.nickName = nickName;
		this.eMail = eMail;
		this.rDate = rDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	
	@Override
	public String toString() {
		return "회원 정보 [아이디=" + id + ", 비밀번호=" + password + ", 닉네임=" + nickName + 
				", 이메일=" + eMail +  ", 가입일=" + rDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (id == null) {
			if(other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickName == null) {
			if(other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if(password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}









