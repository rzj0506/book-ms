package com.zuiqiang.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiqiang.user.dao.ManagerUserMapper;
import com.zuiqiang.user.dao.UserMapper;
import com.zuiqiang.user.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private ManagerUserMapper ManagerUserMapperservice;
	
	@Override
	public int deleteByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	public User selectById(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.selectById(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updatePasswordByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return mapper.updatePasswordByUserId(record);
	}

	@Override
	public int updatePasswordByUserId(User record) {
		// TODO Auto-generated method stub
		return mapper.updatePasswordByUserId(record);
	}

	@Override
	public User selectByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return mapper.selectByEmail(userEmail);
	}
	
	
	
	
}