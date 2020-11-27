package com.zuiqiang.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zuiqiang.user.domain.User;
import com.zuiqiang.user.service.MD5;
import com.zuiqiang.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * 登录
	 * 
	 * @param number
	 * @param password
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Integer userId, String userPassword, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		User user = service.selectByPrimaryKey(userId);

		if (user.getUserPassword().equals(MD5.stringMD5(userPassword))) {

//			System.out.println(user.toString());
			// 创建session对象
			HttpSession session = request.getSession();
			// 把用户数据保存在session域对象中
			session.setAttribute(Integer.toString(userId), userId);

//			System.out.println(session.getAttribute("userId"));
//			不返回密码
//			user = service.selectById(userId);
			String json = JSON.toJSONString(user);
			return json;
		}
		return null;
	}

	/**
	 * 注册或添加一位用户
	 */
	@ResponseBody
	@RequestMapping(value = "/logon", method = RequestMethod.POST)
	public String addUser(User user, Model model) {
		user.setUserPassword(MD5.stringMD5(user.getUserPassword()));
		user.setUserCategory(0);
		System.out.println(user);
		int in = service.insert(user);
		System.out.println(user.toString());
		String addInfo = "添加失败";
		if (in > 0) {
			addInfo = "添加成功";
			String json = JSON.toJSONString(user);
			return json;
		}
		model.addAttribute("addInfo", addInfo);
		return null;
	}

	/**
	 * 判断userId是否已经存在
	 * 
	 * @param user
	 * @return
	 */

	@RequestMapping(value = "/CheckuserId", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public int selectById( Integer userId) {
		
		User user = service.selectById(userId);
		if (user != null) {
			return 1;
		}
		return 0;
	}
	
	
	/**
	 * 判断userEmail是否已经存在
	 * 
	 * @param user
	 * @return
	 */

	@RequestMapping(value = "/CheckuserEmail", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public int selectByEmail( String  userEmail) {
		
		User user = service.selectByEmail(userEmail);
		if (user != null) {
			return 1;
		}
		return 0;
	}
	
	
	/**
	 * 根据Id查找用户
	 * 
	 * @param user
	 * @return
	 */

	@RequestMapping(value = "/get/user", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public String searchById(HttpServletRequest request, Integer userId) {
		System.out.println("sessionId" + request.getHeader("sessionId"));
		
		//判断登录
		String sessionId = request.getHeader("sessionId");
		if (sessionId == null) {
			return null;
		}

		User user = service.selectById(userId);
		if (user != null) {
			String jsonlist = JSON.toJSONString(user);
			return jsonlist;
		}
		return null;
	}

	/**
	 * 修改user信息
	 */
	@ResponseBody
	@RequestMapping(value = "/update/user", method = RequestMethod.POST)
	public String updateUser(User user,HttpServletRequest request) {
		System.out.println(user.toString());
		//判断登录
		String sessionId = request.getHeader("sessionId");
		if (sessionId == null) {
			return null;
		}
		int in = service.updateByPrimaryKeySelective(user);
		User users = service.selectByPrimaryKey(user.getUserId());
		if (in > 0) {
			String json = JSON.toJSONString(users);
			return json;
		}
		return null;
	}

//	/**
//	 * 管理员页面完成
//	 * 删除一个user
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/delete/user", method = RequestMethod.DELETE)
//	public String deleteUser(User user) {
//		user = service.selectByPrimaryKey(user.getUserId());
//		String json = JSON.toJSONString(user);
//		System.out.println(user);
//		if (user.getUserCategory() == 1) {
//			int in = service.deleteByPrimaryKey(user.getUserId());
//			if (in > 0) {
//				return json;
//			}
//		}
//
//		return null;
//	}

	/**
	 * 修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/update/userpassword", method = RequestMethod.POST)
	public String updateUserPassword(Integer userId, String userPassword, String newPassword,
			HttpServletRequest request) {
//		System.out.println("userPassword" + userPassword);
		//判断登录
		String sessionId = request.getHeader("sessionId");
		if (sessionId == null) {
			return null;
		}
		User user = service.selectByPrimaryKey(userId);

		if (user.getUserPassword().equals(MD5.stringMD5(userPassword))) {
//			System.out.println("userPassword2" + userPassword);
			user.setUserPassword(MD5.stringMD5(newPassword));
			System.out.println("userPassword3" + user.getUserPassword());
			int in = service.updatePasswordByPrimaryKey(user);
			if (in > 0) {
				System.out.println("userPassword3" + userPassword);
				String json = JSON.toJSONString(user);
				return json;
			}
		}
		return null;
	}

	/**
	 * 注销
	 * 
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/Logout", method = RequestMethod.POST)
	public String Logout(HttpServletRequest request) {

		System.out.println("sessionId" + request.getHeader("sessionId"));
		// 获得请求头中的sessionId
		String sessionId = request.getHeader("sessionId");
		// 创建session对象
		HttpSession session = request.getSession();
		// 把用户数据保存在session域对象中
//					session.setAttribute("userId", userId);
		System.out.println("sessionId 获取" + session.getAttribute(sessionId));

		session.removeAttribute(request.getHeader("sessionId"));
		System.out.println("sessionId 获取" + session.getAttribute(sessionId));
//		System.out.println("sessionId" + request.getHeader("sessionId"));

		return null;
	}

}
