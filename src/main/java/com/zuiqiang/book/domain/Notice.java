package com.zuiqiang.book.domain;

import java.util.Date;

public class Notice {
    private Integer noticeID;
    private String noticeContent;
    private Date noticeCreatetime;

    public Integer getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(Integer noticeID) {
        this.noticeID = noticeID;
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

    @Override
    public String toString() {
        return "Notice{" +
                "noticeID=" + noticeID +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeCreatetime=" + noticeCreatetime +
                '}';
    }
}
