package com.zuiqiang.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuiqiang.book.dao.BookMapper;
import com.zuiqiang.book.domain.Book;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Book showBookInfo(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    /**根据条件筛选书籍
     * @param bookSort
     * @param bookPub
     * @param status status有三个状态，分别为未赋值，0,1；当未赋值时查询所有，当0时，查询借完的书籍，当1时，查询可借的书籍
     * @return 筛选的书籍的信息(book_name,book_sort,book_author,book_pub,book_num)
     */
    @Override
    public List<Book> selectBooksByConditions(String bookSort, String bookPub, Integer status) {
        //当0时，查询借完的书籍
        if(status==0){
            return bookMapper.selectBooksByConditions0(bookSort,bookPub,status);
        }else if (status==1){//当1时，查询可借的书籍
            return bookMapper.selectBooksByConditions1(bookSort,bookPub,status);
        }else{
            return bookMapper.selectBooksByConditions(bookSort,bookPub);//当-1时查询所有书籍
        }


    }

    @Override
    public List<Book> getBookByInput(String keyword) {
        return bookMapper.getBookByInput( keyword);
    }
}
