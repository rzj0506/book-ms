package com.zuiqiang.book.dao;

import com.zuiqiang.book.domain.BorrowHistory;

public interface BorrowHistoryMapper {
    int deleteByPrimaryKey(Integer historyId);

    int insert(BorrowHistory record);

    int insertSelective(BorrowHistory record);

    BorrowHistory selectByPrimaryKey(Integer historyId);

    int updateByPrimaryKeySelective(BorrowHistory record);

    int updateByPrimaryKey(BorrowHistory record);
}