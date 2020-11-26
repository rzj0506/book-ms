package com.zuiqiang.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiqiang.book.domain.Book;
import com.zuiqiang.user.dao.MyBookshelfMapper;
@Service
public class MyBookshelfServiceImpl implements MyBookshelfService {
    @Autowired
    private MyBookshelfMapper myBookshelfMapper;
    @Override
    public List<Book> listBorrowBooks(Integer userId) {
       List<Book> books =myBookshelfMapper.listBorrowBooks(userId);
        return books;
    }

    @Override
    public List<Book> listNoBorrowBooks(Integer userId) {
        return myBookshelfMapper.listNoBorrowBooks(userId);
    }

    @Override
    public Integer showBorrowCount() {
        return myBookshelfMapper.showBorrowCount();
    }

    @Override
    public void borrowBook(Integer userId, Integer bookId, String borrowDate) {
        Integer count = myBookshelfMapper.showBorrowCount();
        if(count<3){
            myBookshelfMapper.borrowBook(userId,bookId,borrowDate);
        }

    }

    @Override
    public void returnBook(Integer userId, Integer bookId) {
        myBookshelfMapper.returnBook(userId,bookId);
    }


}
