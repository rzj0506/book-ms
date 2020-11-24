package com.zuiqiang.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zuiqiang.notice.domain.Notice;

public interface NoticeMapper {
	int deleteByPrimaryKey(Integer noticeId);

	int insert(Notice record);

	int insertSelective(Notice record);

	Notice selectByPrimaryKey();

	int updateByPrimaryKeySelective(Notice record);

	int updateByPrimaryKey(Notice record);

	// 下面的为使用注解开发

	@Select("select user.user_name,notice.notice_createtime,notice.notice_content from notice left join user on  notice.notice_id = user.user_id") // 公告展示
	@Results(value = { @Result(column = "notice_id", property = "noticeId"),
			@Result(column = "notice_content", property = "noticeContent"),
			@Result(column = "notice_createtime", property = "noticeCreatetime"),
			@Result(column = "user_id", property = "userId"), @Result(column = "user_name", property = "userName") })
	List<Notice> showNoticesAll();

	@Select("select * from notice where notice_content like CONCAT('%',#{noticeContent},'%')") // 公告的模糊查询
	@Results(value = { @Result(column = "notice_id", property = "noticeId"),
			@Result(column = "notice_content", property = "noticeContent"),
			@Result(column = "notice_createtime", property = "noticeCreatetime"),
			@Result(column = "user_id", property = "userId"), })
	List<Notice> findNoticeByLike(String noticeContent);

//	@Select("select * from notice where notice_id in #{noticeId} ")
//	@Results(value = { @Result(column = "notice_id", property = "noticeId"),
//			@Result(column = "notice_content", property = "noticeContent"),
//			@Result(column = "notice_createtime", property = "noticeCreatetime"),
//			@Result(column = "user_id", property = "userId"), })
//
//	List<Notice> getHistoryBynoticeId(Object noticeId);

}