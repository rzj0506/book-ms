package com.zuiqiang.book.dao;

import org.apache.ibatis.annotations.Select;

public interface BorrowCollectionMapper {
	
	@Select("SELECT COUNT(borrow_date) FROM `borrow_history` WHERE to_days(borrow_date) = to_days(now());")
	int BorrowToday();
	
	@Select("SELECT COUNT(return_date) FROM `borrow_history` WHERE to_days(return_date) = to_days(now());")
	int BackToday();
	
	@Select("SELECT COUNT(borrow_date) FROM `borrow_history` WHERE DATE_FORMAT(borrow_date,'%Y-%m') = DATE_FORMAT(now(),'%Y-%m');")
	int BorrowthisMonth();
	
	@Select("SELECT COUNT(return_date) FROM `borrow_history` WHERE DATE_FORMAT(return_date,'%Y-%m') = DATE_FORMAT(now(),'%Y-%m');")
	int BackthisMonth();
	
	@Select("SELECT COUNT(borrow_date) FROM `borrow_history` WHERE YEAR(borrow_date)=YEAR(NOW());")
	int BorrowthisYear();
	
	@Select("SELECT COUNT(return_date) FROM `borrow_history` WHERE YEAR(return_date)=YEAR(NOW());")
	int BackthisYear();
}
