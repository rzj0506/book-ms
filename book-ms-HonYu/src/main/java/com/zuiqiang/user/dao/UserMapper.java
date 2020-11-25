package com.zuiqiang.user.dao;

import com.zuiqiang.user.domain.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	User selectById(Integer userId);
	
	User selectByEmail(String userEmail);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	int updatePasswordByUserId(User record);
  
}