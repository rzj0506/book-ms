package com.zuiqiang.book.controller;

import com.zuiqiang.base_controller.BaseController;
import com.zuiqiang.book.domain.Book;
import com.zuiqiang.book.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/library")
public class Library extends BaseController {
    @Autowired
    private LibraryService libraryService;

    /**点击状态按钮显示书籍信息
     * @param bookId
     * @return 书籍信息
     */
    @GetMapping("/bookInfo/{book_id}")
    @ResponseBody
    public Book showBookInfo(@PathVariable("book_id") Integer bookId){
       Book book= libraryService.showBookInfo(bookId);
        return book;
    }

    /**根据条件筛选书籍
     * @param bookSort
     * @param bookPub
     * @param status status有三个状态，分别为未赋值，0,1；当未赋值时查询所有，当0时，查询借完的书籍，当1时，查询可借的书籍
     * @return 筛选的书籍的信息{book_name,book_sort,book_author,book_pub,book_num}
     */
    @GetMapping("/getBookByConditions")
    @ResponseBody
    public List<Book> selectBooksByConditions( String bookSort , String bookPub, Integer status){
       List<Book> books=libraryService.selectBooksByConditions(bookSort,bookPub,status);
       return books;
    }

    /**模糊查询
     * @param keyword 通过关键字查询书籍
     * @return 查询到的书籍信息{book_name,book_sort,book_author,book_pub,book_num}
     */
    @GetMapping("/getBookByInput/{keyword}")
    @ResponseBody
    public List<Book>  getBookByInput(@PathVariable("keyword") String keyword){
        List<Book> books =libraryService.getBookByInput(keyword);
        return books;
    }

}
