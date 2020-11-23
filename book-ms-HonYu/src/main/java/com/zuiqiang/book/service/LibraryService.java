package com.zuiqiang.book.service;

import com.zuiqiang.book.domain.Book;

import java.util.List;

public interface LibraryService {
    Book showBookInfo(Integer bookId);

    List<Book> selectBooksByConditions(String bookSort, String bookPub, Integer status);

    List<Book> getBookByInput(String keyword);
}

