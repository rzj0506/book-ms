package com.zuiqiang.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zuiqiang.book.domain.Book;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectBooksByConditions(@Param("bookSort") String bookSort,@Param("bookPub") String bookPub );

    List<Book> selectBooksByConditions0(@Param("bookSort") String bookSort, @Param("bookPub")String bookPub,@Param("status") Integer Status);

    List<Book> selectBooksByConditions1(@Param("bookSort") String bookSort,@Param("bookPub") String bookPub,@Param("status") Integer status);

    List<Book> getBookByInput(String keyword);

	
}