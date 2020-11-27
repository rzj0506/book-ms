package com.zuiqiang.book.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.BookMsApplication;
import com.zuiqiang.book.dao.BookMapper;
import com.zuiqiang.book.dao.BookSortMapper;
import com.zuiqiang.book.dao.BorrowHistoryMapper;
import com.zuiqiang.book.dao.ManagerMapper;
import com.zuiqiang.book.domain.Book;
import com.zuiqiang.user.dao.UserMapper;
import com.zuiqiang.user.domain.User;

@Configuration
@CrossOrigin({"http://localhost:8081","null"})
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

	
	//System.getProperty("user.dir")+"//src//main//resources//static";
//	String storePath = "C:\\Users\\Administrator\\git\\20.11.25.1\\book-ms2\\book-ms-HonYu\\src\\main\\resources\\static\\Pic";
	String storePath1 = "resources\\static\\Pic";
	
	String  storePath =BookMsApplication.pathAll;
	/**
	 * 查询某个用户现在有几本书
	 */
	@ResponseBody
	@RequestMapping(value = "/GetUserBookNum",method = RequestMethod.GET)
	public String getUserBookNum(User user) {
		int num = ManagerMapperservice.getUserBookNum(user.getUserId());
		String json = JSON.toJSONString(num);
		
		
			return json;
		
	}
	

	
	/**
	 * 增加图书
	 */
	@ResponseBody
	@RequestMapping(value = "/SaveBook",method = RequestMethod.POST)
	public String addBook(Book book) throws FileNotFoundException {
	
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
	 * 上传图片
	 */
	@ResponseBody
	@RequestMapping(value = "/UploadFile",method = RequestMethod.POST)
	public String uploadfile(MultipartFile file) throws FileNotFoundException {
		Book book =null;
		String fileName =null;
		Map<String, String> modelMap = new HashMap<>();
		if (!file.isEmpty()) {
			System.out.println(storePath+ "/Pic/"  );
		Random r = new Random();
		fileName = file.getOriginalFilename();
		String[] split = fileName.split(".jpg");
		fileName = split[0] + r.nextInt(1000);
		fileName = fileName + ".jpg";
		File filePath = new File(storePath, fileName);
		if (!filePath.getParentFile().exists()) {
			filePath.getParentFile().mkdirs();
		}
		try {
			file.transferTo(new File(storePath + "/Pic/"  + fileName));
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("back", "error");
			String json = JSON.toJSONString(modelMap);
			return json;
		}
		modelMap.put("back", "success");

	} else {
		modelMap.put("back", "error");
	}
		 book=ManagerMapperservice.getBookByPrimaryKeySelective();
		book.setBookImg("/Pic/"+fileName);
		int in= BookMapperservice.updateByPrimaryKeySelective(book);
		if(in > 0) {
			
			String json = JSON.toJSONString(in);
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
		book = ManagerMapperservice.selectByPrimaryKey(book.getBookId());
		
		
		System.out.println(storePath+ "/Pic/" );
		String resultInfo=null;
		File file = new File(storePath+book.getBookImg());
		file.delete();
		System.out.println(book.getBookImg());
		System.out.println(file.getName());
		if (file.exists()) {
  			
  			if (file.delete()) {
				
				resultInfo = "1-删除成功";
			}else {
				
				resultInfo = "0-删除失败1";
			}
		}else {
			resultInfo = "文件不存在！";
		}	
		
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
	public String managerChangeSort(Integer bookId,String bookName,String bookAuthor,String bookPub,String bookSort,String bookRecord,
			String bookImg,String bookIntroduce) {
		
		Date date=null;
		Book book=new Book();
		if(bookRecord!=null) {
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			date = fmt.parse(bookRecord);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(bookId!=null)
			book.setBookId(bookId);
		if(bookName!=null)
		book.setBookName(bookName);
		if(bookAuthor!=null)
		book.setBookAuthor(bookAuthor);
		if(bookPub!=null)
		book.setBookPub(bookPub);
		if(bookSort!=null)
		book.setBookSort(bookSort);
		if(date!=null)
		book.setBookRecord(date);
		if(bookImg!=null)
		book.setBookImg(bookImg);
		if(bookIntroduce!=null)
			book.setBookIntroduce(bookIntroduce);
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
		List<Book> list = ManagerMapperservice.findBookByLike(bookName.replace(" ",""));
	
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
