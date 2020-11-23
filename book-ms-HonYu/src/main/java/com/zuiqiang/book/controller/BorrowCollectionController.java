package com.zuiqiang.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zuiqiang.book.domain.BorrowHistory;
import com.zuiqiang.book.service.BorrowCollectionService;


/**
 * 
 * 图书借出和归还的统计
 * 
 * @author 12645
 *
 */
@Controller
@RequestMapping("/BorrowCollection")

public class BorrowCollectionController {
	@Autowired
	private BorrowCollectionService borrowCollectionService;
	BorrowHistory borrowHistory = new BorrowHistory();
	
	
	
	/**
	 * 图书当天借出的统计
	 * @param null
	 * @return int
	 */
	@GetMapping(value = {"/borrowtoday"})
	@ResponseBody
	public int BorrowToday() {
		return borrowCollectionService.BorrowToday();	
	}
	
	
	/**
	 * 图书当天归还的统计
	 * @param null
	 * @return int
	 */
	@GetMapping(value = {"/backtoday"})
	@ResponseBody
	public int BackToday() {
		return borrowCollectionService.BackToday();
	}
	
	
	/**
	 * 图书当前月份借出的统计
	 * @param null
	 * @return int
	 */
	@GetMapping(value = {"/borrowthismonth"})
	@ResponseBody
	public int BorrowthisMonth() {
		return borrowCollectionService.BorrowthisMonth();
	}
	
	/**
	 * 图书当前月份归还的统计
	 * @param null
	 * @return int
	 */
	@GetMapping(value = {"/backthismonth"})
	@ResponseBody
	public int BackthisMonth() {
		return borrowCollectionService.BackthisMonth();
	}
	
	
	
	/**
	 * 图书当前年份借出的统计
	 * @param null
	 * @return int
	 */
	@GetMapping(value = {"/borrowthisyear"})
	@ResponseBody
	public int BorrowthisYear() {
		return borrowCollectionService.BorrowthisYear();	
	}

	/**
	 * 图书当前年份归还的统计
	 * @param null
	 * @return int
	 */
	@GetMapping(value = {"/backthisyear"})
	@ResponseBody
	public int BackthisYear() {
		return borrowCollectionService.BackthisYear();
	}
}
