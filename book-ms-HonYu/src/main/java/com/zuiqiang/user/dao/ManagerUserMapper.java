package com.zuiqiang.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zuiqiang.user.domain.User;

public interface ManagerUserMapper {
	int updatePasswordByPrimaryKey(User record);
	@Select("select * from user")
	   @Results(value = { 
	    		@Result(column = "user_id", property = "userId"), 
	    		@Result(column = "user_age", property = "userAge"),
	    		@Result(column = "user_email", property = "userEmail"),
	    		@Result(column = "user_sex", property = "userSex"), 
	    		@Result(column = "user_name", property = "userName"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "user_phone", property = "userPhone"), 
	    		@Result(column = "user_password", property = "userPassword"), 
	    		@Result(column = "user_category", property = "userCategory"), 
	    })
    ArrayList<User> count();
	
	 @Options(useGeneratedKeys = true,keyProperty = "id")
	    @Select("select * from user where user_name like CONCAT('%',#{username},'%')")  // 
	    @Results(value = { 
	    		@Result(column = "user_id", property = "userId"), 
	    		@Result(column = "user_age", property = "userAge"),
	    		@Result(column = "user_email", property = "userEmail"),
	    		@Result(column = "user_sex", property = "userSex"), 
	    		@Result(column = "user_name", property = "userName"), 
	    		@Result(column = "book_sort", property = "bookSort"), 
	    		@Result(column = "user_phone", property = "userPhone"), 
	    		@Result(column = "user_password", property = "userPassword"), 
	    		@Result(column = "user_category", property = "userCategory"), 
	    })
		List<User> searchUserByLike(String username);
	 
	 @Select("select user_name from user where user_id=#{userId}")
	String getUserName(User user);
}
