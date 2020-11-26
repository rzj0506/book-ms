package com.zuiqiang.user.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zuiqiang.base_controller.BaseController;
import com.zuiqiang.book.domain.Book;
import com.zuiqiang.user.service.MyBookshelfService;

@Controller
@RequestMapping("/mybook")
public class MyBookshelf extends BaseController {
    @Autowired
    private MyBookshelfService myBookshelfService;

    /** 用户书架展示
     *
     * @return 当前用户已借阅的书籍
     */
    @GetMapping("/listb")
    @ResponseBody
    public List<Book> BookDisplay( ){

//       Integer userId= 1;
    	
        List<Book> books= myBookshelfService.listBorrowBooks(userId);
        return books;
    }

    /**当用户借入书籍未满3本时
     * @return 返回用户未借阅的书籍(既可以借阅的书籍)
     */
    @GetMapping("/listnob")
    @ResponseBody
    public List<Book> BookNoBorrow(){
       Integer count= myBookshelfService.showBorrowCount();
       if(count<3){
           //Integer userId = loginUser.getUserId();
           List<Book> books=myBookshelfService.listNoBorrowBooks(userId);
           return books;
       }
       return null;
    }

    /**借书
     * @param bookId
     */
    @PostMapping("/borrow/{book_id}")
    public  void BorrowBook(@PathVariable("book_id") Integer bookId){

        //Integer userId = loginUser.getUserId();
        Date date=new Date();     //获取一个Date对象
        DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //创建一个格式化日期对象
        String borrowDate = simpleDateFormat.format(date);   //格式化后的时间

        myBookshelfService.borrowBook(userId,bookId,borrowDate);
    }

    /**还书
     * @param bookId
     */
    @PutMapping("/return/{book_id}")
    public void ReturnBook(@PathVariable("book_id") Integer bookId){
        myBookshelfService.returnBook(userId,bookId);
    }

}
