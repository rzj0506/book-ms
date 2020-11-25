package com.zuiqiang.user.service;

import com.zuiqiang.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MyBookshelfService {
    List<Map<Object,Object>> listBorrowBooks(Integer userId);


    List<Book> listNoBorrowBooks(Integer userId);

    Integer showBorrowCount();

    void borrowBook(Integer userId, Integer bookId, String borrowDate);

    void returnBook(Integer userId, Integer bookId);
}
