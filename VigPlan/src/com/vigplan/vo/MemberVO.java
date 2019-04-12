package com.vigplan.vo;

public class MemberVO {
	private Long no;
	private String id;
	private String pw;
	private String nickname;
	private String email;
	private String regdate;

	//	VO에 기본 생성자는 꼭 있어야 되고
	//	클래스 내에 생성자 없으면 Java 컴파일러가 기본생성자를 만든다
	public MemberVO() {
		super();
	}

	public MemberVO(Long no, String id, String pw, String nickname, String email) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", email=" + email
				+ ", regdate=" + regdate + "]";
		
	}
}









