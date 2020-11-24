package com.zuiqiang.notice.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Notice {
	private Integer noticeId;

	private String noticeContent;
	@JSONField(format = "yyyy-MM-dd")
	private Date noticeCreatetime;

	private Integer userId;

	private String userName;

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeCreatetime() {
		return noticeCreatetime;
	}

	public void setNoticeCreatetime(Date noticeCreatetime) {
		this.noticeCreatetime = noticeCreatetime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}