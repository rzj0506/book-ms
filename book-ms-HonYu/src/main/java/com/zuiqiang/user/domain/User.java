package com.zuiqiang.user.domain;

public class User {
	private Integer userId;

	private Integer userAge;

	private String userEmail;

	private String userSex;

	private String userName;

	private String userPhone;

	private String userPassword;

	private Integer userCategory;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(Integer userCategory) {
		this.userCategory = userCategory;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAge=" + userAge + ", userEmail=" + userEmail + ", userSex=" + userSex
				+ ", userName=" + userName + ", userPhone=" + userPhone + ", userPassword=" + userPassword
				+ ", userCategory=" + userCategory + "]";
	}
}