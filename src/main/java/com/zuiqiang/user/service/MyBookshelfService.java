package com.zuiqiang.user.service;

import com.zuiqiang.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyBookshelfService {
    List<Book> listBorrowBooks(Integer userId);


    List<Book> listNoBorrowBooks(Integer userId);

    Integer showBorrowCount();

    void borrowBook(Integer userId, Integer bookId, String borrowDate);

    void returnBook(Integer userId, Integer bookId);
}
