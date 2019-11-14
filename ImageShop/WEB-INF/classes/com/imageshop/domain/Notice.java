package com.imageshop.domain;

import java.util.Date;

public class Notice {

	private static final long serialVersionUID=
			3387194914986839205L;
	
	private int noticeNo;
	private String title;
	private String content;
	private Date regDate;
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
