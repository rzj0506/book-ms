package com.zuiqiang.user.service;

import org.springframework.stereotype.Service;

import com.zuiqiang.user.domain.User;

@Service
public interface UserService {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	User selectById(Integer userId);
	
	User selectByEmail(String userEmail);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	int updatePasswordByPrimaryKey(User record);
	
	int updatePasswordByUserId(User record);
}