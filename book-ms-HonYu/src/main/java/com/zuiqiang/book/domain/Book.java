package com.zuiqiang.book.domain;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookPub;

    private Integer bookNum;

    private String bookSort;

    private Date bookRecord;

    private Integer bookLeft;

    private Integer isreturn;
    
    
    public Integer getIsreturn() {
		return isreturn;
	}

	public void setIsreturn(Integer isreturn) {
		this.isreturn = isreturn;
	}

	public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookSort() {
        return bookSort;
    }

    public void setBookSort(String bookSort) {
        this.bookSort = bookSort;
    }

    public Date getBookRecord() {
        return bookRecord;
    }

    public void setBookRecord(Date bookRecord) {
        this.bookRecord = bookRecord;
    }

    public Integer getBookLeft() {
        return bookLeft;
    }

    public void setBookLeft(Integer bookLeft) {
        this.bookLeft = bookLeft;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPub="
				+ bookPub + ", bookNum=" + bookNum + ", bookSort=" + bookSort + ", bookRecord=" + bookRecord
				+ ", bookLeft=" + bookLeft + ", isreturn=" + isreturn + "]";
	}
    
}