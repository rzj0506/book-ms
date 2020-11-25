package com.zuiqiang.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiqiang.book.dao.BorrowCollectionMapper;

@Service
public class BorrowCollectionServicelmp implements BorrowCollectionService {

	@Autowired
	private BorrowCollectionMapper Borrowcollectionmapper;

	@Override
	public int BorrowToday() {
		// TODO Auto-generated method stub
		return Borrowcollectionmapper.BorrowToday();
	}

	@Override
	public int BackToday() {
		// TODO Auto-generated method stub
		return Borrowcollectionmapper.BackToday();
	}

	@Override
	public int BorrowthisMonth() {
		// TODO Auto-generated method stub
		return Borrowcollectionmapper.BorrowthisMonth();
	}

	@Override
	public int BackthisMonth() {
		// TODO Auto-generated method stub
		return Borrowcollectionmapper.BackthisMonth();
	}

	@Override
	public int BorrowthisYear() {
		// TODO Auto-generated method stub
		return Borrowcollectionmapper.BorrowthisYear();
	}

	@Override
	public int BackthisYear() {
		// TODO Auto-generated method stub
		return Borrowcollectionmapper.BackthisYear();
	}

}
