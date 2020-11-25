package com.zuiqiang.book.service;

import org.springframework.stereotype.Repository;

@Repository
public interface BorrowCollectionService {

	int BorrowToday();// 当天借出的书本的数量统计

	int BackToday();// 当天归还的书本的数量统计

	int BorrowthisMonth();// 当月份借出的书本的数量统计

	int BackthisMonth();// 当前月份归还的书本的数量统计

	int BorrowthisYear();// 本年度借出的书本的数量统计

	int BackthisYear();// 本年度归还的书本的数量统计

}
