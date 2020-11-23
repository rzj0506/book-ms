package com.zuiqiang.notice.domain;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private String noticeContent;

    private Date noticeCreatetime;

    private Integer userId;

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
}