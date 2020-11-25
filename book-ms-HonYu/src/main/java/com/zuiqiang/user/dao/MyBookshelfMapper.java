package com.zuiqiang.user.dao;

import com.zuiqiang.book.domain.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MyBookshelfMapper {

    List<Map<Object,Object>> listBorrowBooks(Integer userId);



    List<Book> listNoBorrowBooks(Integer userId);

    Integer showBorrowCount();

    void borrowBook(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("borrowDate") String borrowDate);

    void returnBook(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
}
