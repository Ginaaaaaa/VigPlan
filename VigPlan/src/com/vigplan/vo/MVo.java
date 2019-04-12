package com.vigplan.vo;

public class MVo {

	private String mTitle;
	private String mDate;
	private String mPlace;
	private String mContent;
	
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String getmPlace() {
		return mPlace;
	}
	public void setmPlace(String mPlace) {
		this.mPlace = mPlace;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	
	@Override
	public String toString() {
		return "MVo [mTitle=" + mTitle + ", mDate=" + mDate + ", mPlace=" + mPlace + ", mContent=" + mContent + "]";
	}
	
}