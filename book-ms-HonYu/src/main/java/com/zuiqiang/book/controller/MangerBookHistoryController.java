package com.zuiqiang.book.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.book.dao.BookMapper;
import com.zuiqiang.book.dao.BorrowHistoryMapper;
import com.zuiqiang.book.dao.ManagerMapper;
import com.zuiqiang.book.domain.Book;
import com.zuiqiang.book.domain.BorrowHistory;
import com.zuiqiang.user.domain.User;

@Controller
public class MangerBookHistoryController {

	@Autowired
	private BorrowHistoryMapper BorrowHistoryMapperservice;
	
	@Autowired
	private BookMapper BookMapperservice;
	
	@Autowired
	private ManagerMapper 	ManagerMapperservice;
	/**
	 * 图书借阅
	 */
	@ResponseBody
	@RequestMapping(value = "/SaveBorrowHistory",method = RequestMethod.POST)
	public String addDept(HttpServletRequest request,BorrowHistory borrowHistory) {
		
		
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		Date date = null;
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		borrowHistory.setBorrowDate(date);
		int in = ManagerMapperservice.inserta(borrowHistory);
		if(in > 0) {
			
			String json = JSON.toJSONString(borrowHistory);
			return json;
		}
		return null;
	}
	/**
	 * 图书归还
	 */
	@ResponseBody
	@RequestMapping(value = "/ReturnBookHistory",method = RequestMethod.POST)
	public String addDept2(BorrowHistory borrowHistory) {
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		borrowHistory.setReturnDate(date);
		borrowHistory.setIsreturn(1);
		int in = BorrowHistoryMapperservice.updateByPrimaryKeySelective(borrowHistory);
		if(in > 0) {
			
			String json = JSON.toJSONString(borrowHistory);
			return json;
		}
		return null;
	}
	/**
	 * 根据id查某个user借阅历史
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectUserHistoryById",method = RequestMethod.POST)
	public String searchDeptById(User user,Integer page, Integer rows) {
		List<Book> list=ManagerMapperservice.getHistoryById(user.getUserId());
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total +",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}
	/**
	 * 查询全部借阅历史
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectHistoryAll",method = RequestMethod.GET)
	public String findHistoryAll(Integer page, Integer rows) {
		List<BorrowHistory> list=ManagerMapperservice.getHistoryAll();
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total +",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}
	/**
	 * 模糊查询全部借阅历史
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectHistoryByLikeT",method = RequestMethod.POST)
	public String findHistoryByLike(String bookname,Integer page, Integer rows) {
		Book book = ManagerMapperservice.findBookByLikelimit1(bookname);
		List<BorrowHistory> list=ManagerMapperservice.getHistoryByBookId(book.getBookId());
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"bookname\":" + book.getBookName() +",\"total\":" + total+",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}

}
