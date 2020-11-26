package com.zuiqiang.notice.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Notice {
	private Integer noticeId;// 设置公告的公告id

	private String noticeContent;// 公告的内容

	@JSONField(format = "yyyy-MM-dd") // 使用注解避免返回页面的时间为时间戳
	private Date noticeCreatetime;// 设置公告的内容

	private Integer userId;// 设置对应用户的id，用于和user的表的用户userId外联

	private String userName;// 外联获取的用户姓名

	// 以下为getter和setter

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