package com.zuiqiang.book.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zuiqiang.book.domain.Book;
import com.zuiqiang.book.domain.BookSort;
import com.zuiqiang.book.domain.BorrowHistory;

public interface ManagerMapper {

	 @Select("select book_num from book where book_id= #{bookId}")
		int tofindBookNumById(Integer bookId);
	    
	    @Select("select book_Left from book where book_id= #{bookId}")
		int tofindBookLeftById(Integer bookId);

	    
	    @Select("select book_id,book_name,book_author,book_pub,book_num,book_sort"
	    		+ " ,book_record,book_left from book")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    })
		public List<Book> findAllBook() throws IOException;
	    @Select("select book_id,book_name,book_author,book_pub"
	    		+ ",book_num,book_sort,book_record,book_left from book where book_name like CONCAT('%',#{bookName},'%')")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    })  
		public List<Book> findBookByLike(String bookName);

	    @Select("select count(*) from book where book_name= #{bookName}")
		int tofindBookNumByName(String bookName);

	    @Select("select count(*) from book where book.book_name=#{bookName} and book_id not in \r\n" + 
	    		"(select borrow_history.book_id from borrow_history where borrow_history.isreturn =0)")
		int tofindBookLeftByName(String bookName);
	    
	    @Select("select book_id,book_name,book_author,book_pub,"
	    		+ "book_num,book_sort,book_record,book_left from book where book_name like CONCAT('%',#{keyWord},'%') limit 0,1")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    })  
		Book findBookByLikelimit1(String bookname);

	    @Select("select * from book where (book_name=#{bookName} or #{bookName} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_pub=#{bookPub} or #{bookPub} is null) and (book_num=#{bookNum} or #{bookNum} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null) and (book_record=#{bookRecord} or #{bookRecord} is  null)"
	    		+ "and (book_left=#{bookLeft} or #{bookLeft} is  null)")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    }) 
	    List<Book> selectBookByChiose(Book book);

	    
	    @Select("select distinct book_author from book")
	    @Results(value = { 
	    		@Result(column = "book_author", property = "bookAuthor"),
	  
	    })  
		List<String> getAuthor();
	    
	    @Select("select distinct book_pub from book")
	    @Results(value = { 
	    		@Result(column = "book_pub", property = "bookPub"),
	  
	    })  
		List<String> getPub();

	    @Select("select distinct book_Sort from book")
	    @Results(value = { 
	    		@Result(column = "book_Sort", property = "bookPub"),
	  
	    })  
		List<String> getSort();
	    @Select("select * from book where (book_name=#{bookName} or #{bookName} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_pub=#{bookPub} or #{bookPub} is null) and (book_num=#{bookNum} or #{bookNum} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null) and (book_record=#{bookRecord} or #{bookRecord} is  null)"
	    		+ "and (book_left=#{bookLeft} or #{bookLeft} is  null) order by book_record")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    }) 
		List<Book> selectBookByChioseOrderRecord(Book book);
	    
	    @Select("select * from book where (book_name=#{bookName} or #{bookName} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_pub=#{bookPub} or #{bookPub} is null) and (book_num=#{bookNum} or #{bookNum} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null) and (book_record=#{bookRecord} or #{bookRecord} is  null)"
	    		+ "and (book_left=#{bookLeft} or #{bookLeft} is  null) order by book_record desc")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    }) 
		List<Book> selectBookByChioseDescRecord(Book book);

		
	    @Select("select distinct book.book_id, book.book_name,book.book_pub,book.book_author,\r\n" + 
	    		"book.book_sort,book.book_record,ifnull(isreturn,1) as isreturn from book LEFT OUTER \r\n" + 
	    		"join borrow_history on book.book_id=borrow_history.book_id where book.book_id is not null "
	    		+ "and  (book_pub=#{bookPub} or #{bookPub} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null)"
	    		+ "and (ifnull(isreturn,1)=#{isreturn} or #{isreturn} is  null) order by book_record desc")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    }) 
		List<Book> selectBookHistoryByChioseDescRecord(Book book);
	    @Select("select distinct book.book_id, book.book_name,book.book_pub,book.book_author,\r\n" + 
	    		"book.book_sort,book.book_record,ifnull(isreturn,1) as isreturn from book LEFT OUTER \r\n" + 
	    		"join borrow_history on book.book_id=borrow_history.book_id where book.book_id is not null and "
	    		+ " (book_pub=#{bookPub} or #{bookPub} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null)"
	    		+ "and (ifnull(isreturn,1)=#{isreturn} or #{isreturn} is  null) order by book_record")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    }) 
		List<Book> selectBookHistoryByChioseOrderRecord(Book book);

		
	    @Select("select distinct book.book_id, book.book_name,book.book_pub,book.book_author,\r\n" + 
	    		"book.book_sort,book.book_record,ifnull(isreturn,1) as isreturn from book LEFT OUTER \r\n" + 
	    		"join borrow_history on book.book_id=borrow_history.book_id where book.book_id is not null and book.book_name like CONCAT('%',#{bookName},'%')")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    }) 
		List<Book> selectHistoryByLike(Book book);
	    
	    @Select("select sort_name from booksort")
	    
	    @Results(value = { 
	    		@Result(column = "sort_id", property = "sortId"), 
	    		@Result(column = "sort_name", property = "sortName"),
	    	 })
		List<BookSort> findAllBookSort();
	    
	    @Select("select  book.book_id, book.book_name,book.book_sort,book.book_author,\r\n" + 
	    		"borrow_history.return_date,borrow_history.borrow_date,borrow_history.return_date,validity_date from borrow_history LEFT OUTER \r\n" + 
	    		"join book on book.book_id=borrow_history.book_id where book.book_id is not null"
	    		+ " and user_id=#{userId} and book_name like CONCAT('%',#{bookName},'%')")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    	
	    		
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "borrow_date", property = "borrowDate"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    }) 
	    public List<Book> getHistoryByIdLikeName(Integer userId ,String bookName);

	    @Select("select distinct book.book_id, book.book_name,book.book_pub,book.book_author,\r\n" + 
	    		" validity_date, book.book_sort,return_date,borrow_date,book.book_record,ifnull(isreturn,1) as isreturn from book LEFT OUTER \r\n" + 
	    		"join borrow_history on book.book_id=borrow_history.book_id where book.book_id is not null and "
	    		+ " (book_pub=#{bookPub} or #{bookPub} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null)"
	    		+ "and (ifnull(isreturn,1)=#{isreturn} or #{isreturn} is  null) order by book_record")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "borrow_date", property = "borrowDate"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    }) 
		List<Book> getHistoryAll(Book book);

	    @Select("select distinct book.book_id, book.book_name,book.book_pub,book.book_author,\r\n" + 
	    		" validity_date,book.book_sort,return_date,borrow_date,book.book_record,ifnull(isreturn,1) as isreturn from book LEFT OUTER \r\n" + 
	    		"join borrow_history on book.book_id=borrow_history.book_id where book.book_id is not null and "
	    		+ " (book_pub=#{bookPub} or #{bookPub} is null) and (book_author=#{bookAuthor} or #{bookAuthor} is null)"
	    		+ "and (book_sort=#{bookSort} or #{bookSort} is  null)"
	    		+ "and (ifnull(isreturn,1)=#{isreturn} or #{isreturn} is  null) order by book_record desc")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "borrow_date", property = "borrowDate"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    }) 
		List<Book> getHistoryAllDesc(Book book);
	    
	    @Select("select distinct book.book_id, book.book_name,book.book_pub,book.book_author,\r\n" + 
	    		" validity_date,book.book_sort,return_date,borrow_date,book.book_record,ifnull(isreturn,1) as isreturn from book LEFT OUTER \r\n" + 
	    		"join borrow_history on book.book_id=borrow_history.book_id where book.book_id is not null and "
	    		+ "  book_name like CONCAT('%',#{bookName},'%')")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    		@Result(column = "book_pub", property = "bookPub"), 
	    		@Result(column = "book_num", property = "bookNum"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "book_record", property = "bookRecord"), 
	    		@Result(column = "book_left", property = "bookLeft"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "borrow_date", property = "borrowDate"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    }) 
		List<Book> getHistoryAllByLike(Book book);
	    
	    
	    @Select("select * from borrow_history where book_id CONCAT('%',#{bookid},'%')")
	    @Results(value = { 
	    		@Result(column = "user_id", property = "userId"), 
	    		@Result(column = "book_id", property = "bookId"),
	    		@Result(column = "borrow_date", property = "borrowDate"),
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    		@Result(column = "history_id", property = "historyId"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    	 })
		List<BorrowHistory> findHistoryByLike(int bookid);

	    @Select("select isreturn from borrow_history where book_id =#{bookid}")
		int findisreturn(Integer bookid);

	   
	    @Select("select * from borrow_history where book_id =#{bookid} limit 0,1")
	    @Results(value = { 
	    		@Result(column = "user_id", property = "userId"), 
	    		@Result(column = "book_id", property = "bookId"),
	    		@Result(column = "borrow_date", property = "borrowDate"),
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "isreturn", property = "isreturn"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    		@Result(column = "history_id", property = "historyId"), 
	    	 })
		List<BorrowHistory> getHistoryByBookId(Integer bookId);

	    @Insert("insert into borrow_history(user_id,book_id,borrow_date,validity_date) " +
	    	       "values(#{userId},#{bookId},#{borrowDate},#{validityDate})")
		int inserta(BorrowHistory borrowHistory);

		
	    
	    @Select("select  book.book_id, book.book_name,book.book_sort,book.book_author,\r\n" + 
	    		"borrow_history.return_date,borrow_history.borrow_date,borrow_history.return_date,validity_date from borrow_history LEFT OUTER \r\n" + 
	    		"join book on book.book_id=borrow_history.book_id where book.book_id is not null"
	    		+ " and user_id=#{userId}")
	    @Results(value = { 
	    		@Result(column = "book_id", property = "bookId"), 
	    		@Result(column = "book_name", property = "bookName"),
	    		@Result(column = "book_author", property = "bookAuthor"),
	    	
	    		
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "return_date", property = "returnDate"), 
	    		@Result(column = "borrow_date", property = "borrowDate"), 
	    		@Result(column = "validity_date", property = "validityDate"), 
	    }) 
	    List<Book> getHistoryById(Integer userId);

		
}
