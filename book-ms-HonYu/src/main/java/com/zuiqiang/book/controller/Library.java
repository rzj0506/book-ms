package com.zuiqiang.book.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.base_controller.BaseController;
import com.zuiqiang.book.domain.Book;
import com.zuiqiang.book.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * @param bookSort 类型 ，不赋值则查询所有
     * @param bookPub 出版社，不赋值则查询所有
     * @param status status有三个状态，分别为-1，0,1；当-1时查询所有，当0时，查询借完的书籍，当1时，查询可借的书籍
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
     * @param page 第几页
     * @param rows  每页有几行
     * @return 查询到的书籍信息{book_name,book_sort,book_author,book_pub,book_num}
     */
    @GetMapping("/getBookByInput")
    @ResponseBody
    public List<Book>  getBookByInput(String keyword, Integer page, Integer rows,Model model){
        PageHelper.startPage(page,rows);
        List<Book> books =libraryService.getBookByInput(keyword);
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        long total = bookPageInfo.getTotal();
        model.addAttribute("total",total);
        return books;
    }


}
