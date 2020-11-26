package com.zuiqiang.notice.service;

import org.springframework.stereotype.Repository;

import com.zuiqiang.notice.domain.Notice;

@Repository
public interface Noticeservice {

	Notice selectByPrimaryKey();// 由公告id查询公告内容

	int insert(Notice record);// 所有的字段都会添加一遍即使没有值

	int insertSelective(Notice record);// 只给有值的字段赋值（会对传进来的值做非空判断）

	int updateByPrimaryKey(Notice record); // updateByPrimaryKey对注入的字段全部更新

	int updateByPrimaryKeySelective(Notice record);// updateByPrimaryKeySelective会对字段进行判断再更新(如果为Null就忽略更新)，如果你只想更新某一字段，可以用这个方法。

	int deleteByPrimaryKey(Integer noticeId);// 刪除

	String showNoticesAll(int page, int rows);// 公告列表展示

//	String findNoticeAll(String noticeContent);// 查询

	String findNoticeByLike(String noticeContent, Integer page, Integer rows); // 公告的模糊查询

}
