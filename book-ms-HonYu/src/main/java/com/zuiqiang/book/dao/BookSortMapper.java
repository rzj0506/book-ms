package com.zuiqiang.book.dao;

import com.zuiqiang.book.domain.BookSort;

public interface BookSortMapper {
    int deleteByPrimaryKey(Integer sortId);

    int insert(BookSort record);

    int insertSelective(BookSort record);

    BookSort selectByPrimaryKey(Integer sortId);

    int updateByPrimaryKeySelective(BookSort record);

    int updateByPrimaryKey(BookSort record);
}