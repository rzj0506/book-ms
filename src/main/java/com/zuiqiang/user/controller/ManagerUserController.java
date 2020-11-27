package com.zuiqiang.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.user.dao.ManagerUserMapper;
import com.zuiqiang.user.dao.UserMapper;
import com.zuiqiang.user.domain.User;





@Controller
public class ManagerUserController {
	@Autowired
	private UserMapper service;
	
	@Autowired
	private ManagerUserMapper ManagerUserMapperservice;
	
	/**
	 *根据用户ip获取姓名
	 */
	@ResponseBody
	@RequestMapping(value = "/GetUserName",method = RequestMethod.GET)
	public String getUserName(User user) {
		String username = ManagerUserMapperservice.getUserName(user);
		if(!username.isEmpty()) {
			
			String json = JSON.toJSONString(username);
			return json;
		}
		return null;
	}
	
	
	/**
	 * 添加新用户
	 */
	@ResponseBody
	@RequestMapping(value = "/SaveUser",method = RequestMethod.POST)
	public String addDept(User user) {
		int in = service.insert(user);
		if(in > 0) {
			
			String json = JSON.toJSONString(user);
			return json;
		}
		return null;
	}
	/**
	 * 删除一个用户
	 */
	@ResponseBody
	@RequestMapping(value = "/DeleteUser",method = RequestMethod.GET)
	public String deleteDept(User user) {
		user = service.selectByPrimaryKey(user.getUserId());
		String json = JSON.toJSONString(user);
		int in = service.deleteByPrimaryKey(user.getUserId());
		if(in>0) {
			return json;
		}
		return null;
	}
	/**
	 * 根据id查询user
	 */
	@ResponseBody
	@RequestMapping(value = "/GetUserById",method = RequestMethod.GET)
	public String searchDeptById(User user) {
		user = service.selectByPrimaryKey(user.getUserId());
		if(user != null) {
			String jsonlist = JSON.toJSONString(user);
			return jsonlist;
		}
		return null;
	}
	/**
	 * 查询用户总数
	 */
	@ResponseBody
	@RequestMapping(value = "/GetUserNum",method = RequestMethod.GET)
	public String userTotal() {
		List<User> list = ManagerUserMapperservice.count();
		int in = list.size();
		String json = JSON.toJSONString(in);
		System.out.println(in);
		return json;
	}
	/**
	 * 查询所有user 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectUserAll",method = RequestMethod.GET)
	public String searchDept(Integer page, Integer rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<User> list = new ArrayList<User>();
		list = ManagerUserMapperservice.count();
		if(list.size() != 0) {
			PageInfo info = new PageInfo<>(list);
			String jsonlist = JSON.toJSONString(list);
			long total = info.getTotal();
			String json = "{\"total\":" + total + ",\"data\":" + jsonlist + "}";
	 		return json;
		}
		return null;
	}
	/**
	 * 模糊查询用户名字
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectUserByLike",method = RequestMethod.POST)
	public String searchUserByLike(String userName,Integer page, Integer rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<User> list = new ArrayList<User>();
		list = ManagerUserMapperservice.searchUserByLike(userName);
		System.out.println(list.get(0));
		if(list.size() != 0) {
			PageInfo info = new PageInfo<>(list);
			String jsonlist = JSON.toJSONString(list);
			long total = info.getTotal();
			String json = "{\"total\":" + total + ",\"data\":" + jsonlist + "}";
	 		return json;
		}
		return null;
	}
	/**
	 * 修改一个用户
	 */
	@ResponseBody
	@RequestMapping(value = "/UpdateUser",method = RequestMethod.POST)
	public String managerChangeSort(User user) {
		
		String json = JSON.toJSONString(user);
		int in = service.updateByPrimaryKeySelective(user);
		if(in>0) {
			return json;
		}
		return null;
	}
}
