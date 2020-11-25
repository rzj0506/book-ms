package com.zuiqiang.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiqiang.book.domain.Book;
import com.zuiqiang.user.dao.MyBookshelfMapper;
@Service
public class MyBookshelfServiceImpl implements MyBookshelfService {
    @Autowired
    private MyBookshelfMapper myBookshelfMapper;
    @Override
    public List<Map<Object,Object>> listBorrowBooks(Integer userId) {
        List<Map<Object,Object>> maps =myBookshelfMapper.listBorrowBooks(userId);
        return maps;
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
