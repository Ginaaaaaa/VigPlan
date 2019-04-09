package com.vigplan.vo;

public class BoardVo {
	
	private String id;
	private String password;
	private String writer;
	private String title;
	private String content;
	private String view_cnt;
	private String reg_date;

	
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(String view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardVo [id=" + id + ", writer=" + writer + ", title=" + title + ", content=" + content + ", view_cnt="
				+ view_cnt + ", reg_date=" + reg_date + "]";
	}






	

}
