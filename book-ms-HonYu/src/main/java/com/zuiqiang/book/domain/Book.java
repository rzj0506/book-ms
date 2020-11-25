package com.zuiqiang.book.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Book {
	private Integer bookId;

	private String bookName;

	private String bookAuthor;
	private Integer historyId;
	private String bookPub;

	private Integer bookNum;

	private String bookSort;
	@JSONField(format = "yyyy-MM-dd")
	private Date bookRecord;

	private Integer bookLeft;

	private Integer isreturn;
	@JSONField(format = "yyyy-MM-dd")
	private Date borrowDate;
	@JSONField(format = "yyyy-MM-dd")
	private Date returnDate;
	private Integer validityDate;

	private String book_img;
	private String book_introduce;

	private Integer userId;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	public String getBook_introduce() {
		return book_introduce;
	}

	public void setBook_introduce(String book_introduce) {
		this.book_introduce = book_introduce;
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

	public Integer getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Integer validityDate) {
		this.validityDate = validityDate;
	}

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
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", historyId="
				+ historyId + ", bookPub=" + bookPub + ", bookNum=" + bookNum + ", bookSort=" + bookSort
				+ ", bookRecord=" + bookRecord + ", bookLeft=" + bookLeft + ", isreturn=" + isreturn + ", borrowDate="
				+ borrowDate + ", returnDate=" + returnDate + ", validityDate=" + validityDate + ", book_img="
				+ book_img + ", book_introduce=" + book_introduce + ", userId=" + userId + ", userName=" + userName
				+ "]";
	}

}