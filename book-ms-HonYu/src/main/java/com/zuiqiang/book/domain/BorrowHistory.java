package com.zuiqiang.book.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class BorrowHistory {
    private Integer historyId;

    private Integer userId;

    private Integer bookId;
    @JSONField(format = "yyyy-MM-dd")
    private Date borrowDate;
    @JSONField(format = "yyyy-MM-dd")
    private Date returnDate;

    private Integer isreturn;
    private Integer validityDate;
    


	public Integer getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Integer validityDate) {
		this.validityDate = validityDate;
	}

	public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(Integer isreturn) {
        this.isreturn = isreturn;
    }

	@Override
	public String toString() {
		return "BorrowHistory [historyId=" + historyId + ", userId=" + userId + ", bookId=" + bookId + ", borrowDate="
				+ borrowDate + ", returnDate=" + returnDate + ", isreturn=" + isreturn + ", ValidityDate="
				+ validityDate + "]";
	}

	
    
}
