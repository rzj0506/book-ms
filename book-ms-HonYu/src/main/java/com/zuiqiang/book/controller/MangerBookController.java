package com.zuiqiang.book.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.book.dao.BookMapper;
import com.zuiqiang.book.dao.BookSortMapper;
import com.zuiqiang.book.dao.BorrowHistoryMapper;
import com.zuiqiang.book.dao.ManagerMapper;
import com.zuiqiang.book.domain.Book;
import com.zuiqiang.user.dao.UserMapper;
import com.zuiqiang.user.domain.User;

@Controller
public class MangerBookController {
	@Autowired
	private BookMapper BookMapperservice;
	
	@Autowired
	private BorrowHistoryMapper BorrowHistoryMapperservice;
	
	@Autowired
	private UserMapper Userservice;
	
	@Autowired
	private BookSortMapper BookSortMapperservice;
	
	@Autowired
	private ManagerMapper 	ManagerMapperservice;

	
	
	/**
	 * 查询某个用户现在有几本书
	 */
	@ResponseBody
	@RequestMapping(value = "/GetUserBookNum",method = RequestMethod.GET)
	public String getUserBookNum(User user) {
		int num = ManagerMapperservice.getUserBookNum(user.getUserId());
		String json = JSON.toJSONString(num);
		
		if(num<=3) {
			return json;
		}
		return null;
	}
	
	/**
	 * 增加图书
	 */
	@ResponseBody
	@RequestMapping(value = "/SaveBook",method = RequestMethod.POST)
	public String addBook(Book book) {
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setBookRecord(date);
		
		

		
		
		
		int in = BookMapperservice.insert(book);
		if(in > 0) {
			
			String json = JSON.toJSONString(book);
			return json;
		}
		return null;
	}
	
	/**
	 * 删除一个图书
	 */
	@ResponseBody
	@RequestMapping(value = "/DeleteBook",method = RequestMethod.GET)
	public String managerDeleteBook(Book book) {
		book = BookMapperservice.selectByPrimaryKey(book.getBookId());
		String json = JSON.toJSONString(book);
		int in = BookMapperservice.deleteByPrimaryKey(book.getBookId());
		if(in>0) {
			return json;
		}
		return null;
	}
	/**
	 * 修改一个图书
	 */
	@ResponseBody
	@RequestMapping(value = "/UpdateBook",method = RequestMethod.POST)
	public String managerChangeSort(Book book) {
		
		String json = JSON.toJSONString(book);
		int in = BookMapperservice.updateByPrimaryKeySelective(book);
		if(in>0) {
			return json;
		}
		return null;
	}
	/**
	 * 根据书名查某个图书总量
	 */
	@ResponseBody
	@RequestMapping(value = "/GetBookNumByName",method = RequestMethod.GET)
	public String findBookNumById(Book book) {
		int num=ManagerMapperservice.tofindBookNumByName(book.getBookName());

		if(book!= null) {
			String jsonlist = JSON.toJSONString(num);
			return jsonlist;
		} 
		return null;
	}
	/**
	 * 根据id查某个图书剩余
	 */
	@ResponseBody
	@RequestMapping(value = "/GetBookLeftNumByName",method = RequestMethod.GET)
	public String findBookLeftByNumByName(Book book) {
	
		int num=ManagerMapperservice.tofindBookLeftByName(book.getBookName());

		if(book!= null) {
			String jsonlist = JSON.toJSONString(num);
			return jsonlist;
		} 
		return null;
	}
	/**
	 * 查询所有图书并分页
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectBook",method = RequestMethod.GET)
	public String searchEmployee(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.findAllBook();
	
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
	 * 筛选查询
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectBookByChiose",method = RequestMethod.POST)
	public String selectBookByChiose(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.selectBookByChiose(book);
	
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
	 * 模糊查询所有图书并分页
	 * @throws IOException 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/SearchBookByLike",method = RequestMethod.POST)
	public String searchBookByLike(String bookName,Integer page, Integer rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.findBookByLike(bookName);
	
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
	 * 查询所有的作者
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/GetAuthor",method = RequestMethod.GET)
	public String getAuthor() throws IOException {
		
		List<String> list = ManagerMapperservice.getAuthor();
	
		int total=list.size();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total +",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}
	/**
	 * 查询所有的作者
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/GetPub",method = RequestMethod.GET)
	public String getPub() throws IOException {
		
		List<String> list = ManagerMapperservice.getPub();
	
		int total=list.size();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total +",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}
	/**
	 * 查询所有的作者
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/GetSort",method = RequestMethod.GET)
	public String getSort() throws IOException {
		
		List<String> list = ManagerMapperservice.getSort();
	
		int total=list.size();
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total +",\"data\":" + jsonlist +"}";
		if(list.size() != 0) {
			return json;
		} 
		return null;
	}
	/**
	 * 筛选查询 按时间大排序
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectBookByChioseOrderRecord",method = RequestMethod.POST)
	public String selectBookByChioseOrderRecord(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.selectBookByChioseOrderRecord(book);
	
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
	 * 筛选查询 按时间小排序
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectBookByChioseDescRecord",method = RequestMethod.POST)
	public String selectBookByChioseDescRecord(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.selectBookByChioseOrderRecord(book);
	
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
	 * 筛选历史查询 按时间大排序
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectBookHistoryByChioseOrderRecord",method = RequestMethod.POST)
	public String selectBookHistoryByChioseOrderRecord(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.selectBookHistoryByChioseOrderRecord(book);
	
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
	 * 筛选书本+isreturn查询 按时间小排序
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectBookHistoryByChioseDescRecord",method = RequestMethod.POST)
	public String selectBookHistoryByChioseDescRecord(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.selectBookHistoryByChioseDescRecord(book);
	
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
	 * 模糊查询
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/SelectHistoryByLike",method = RequestMethod.POST)
	public String selectHistoryByLike(Book book,int page, int rows) throws IOException {
		PageHelper.startPage(page,rows);
		List<Book> list = ManagerMapperservice.selectHistoryByLike(book);
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
