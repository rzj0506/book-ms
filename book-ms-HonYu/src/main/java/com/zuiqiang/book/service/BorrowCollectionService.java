package com.zuiqiang.book.service;

import org.springframework.stereotype.Repository;
@Repository
public interface BorrowCollectionService {
	
	int BorrowToday();
	
	int BackToday();
	
	int BorrowthisMonth();
	
	int BackthisMonth();
	
	int BorrowthisYear();
	
	int BackthisYear();

}
