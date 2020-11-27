package com.zuiqiang.book.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.book.dao.BookSortMapper;
import com.zuiqiang.book.dao.ManagerMapper;
import com.zuiqiang.book.domain.BookSort;

@Controller
public class MangerBookSortController {
	@Autowired
	private BookSortMapper BookSortMapperservice;
	
	@Autowired
	private ManagerMapper 	ManagerMapperservice;
	/**
	 * 增加图书类别
	 */
	@ResponseBody
	@RequestMapping(value = "/SaveBorrowSort",method = RequestMethod.POST)
	public String addBorrowSort(BookSort booksort) {
		int in = BookSortMapperservice.insert(booksort);
		if(in > 0) {
			
			String json = JSON.toJSONString(booksort);
			return json;
		}
		return null;
	}
	/**
	 * 删除一个类别
	 */
	@ResponseBody
	@RequestMapping(value = "/DeleteSort",method = RequestMethod.GET)
	public String deleteDept(BookSort booksort) {
		booksort = BookSortMapperservice.selectByPrimaryKey(booksort.getSortId());
		String json = JSON.toJSONString(booksort);
		int in = BookSortMapperservice.deleteByPrimaryKey(booksort.getSortId());
		if(in>0) {
			return json;
		}
		return null;
	}
	/**
	 * 修改一个类别
	 */
	@ResponseBody
	@RequestMapping(value = "/UpdateSort",method = RequestMethod.POST)
	public String managerChangeSort(BookSort booksort) {
		
		String json = JSON.toJSONString(booksort);
		int in = BookSortMapperservice.updateByPrimaryKey(booksort);
		if(in>0) {
			return json;
		}
		return null;
	}
	/**
	 * 查询所有分页
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectSort",method = RequestMethod.GET)
	public String searchSort(BookSort bookSort,Integer page, Integer rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<BookSort> list = ManagerMapperservice.findAllBookSort();
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total +",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}
}
