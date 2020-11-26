package com.zuiqiang.notice.service.lmp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zuiqiang.notice.dao.NoticeMapper;
import com.zuiqiang.notice.domain.Notice;
import com.zuiqiang.notice.service.Noticeservice;

@Service
public class Noticeservicelmp implements Noticeservice {

	@Autowired
	private NoticeMapper noticemapper;

	@Override
	public Notice selectByPrimaryKey() {
		// TODO Auto-generated method stub
		return noticemapper.selectByPrimaryKey();
	}

	@Override
	public int insert(Notice record) {
		// TODO Auto-generated method stub

		return noticemapper.insert(record);
	}

	@Override
	public int insertSelective(Notice record) {
		// TODO Auto-generated method stub
		return noticemapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(Notice record) {
		// TODO Auto-generated method stub
		return noticemapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Notice record) {
		// TODO Auto-generated method stub
		return noticemapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer noticeId) {
		// TODO Auto-generated method stub
		return noticemapper.deleteByPrimaryKey(noticeId);
	}

	@Override
	public String showNoticesAll(int page, int rows) { // 列出所有公告的内容
		// 测试的url
		// http://localhost:8081/admin/notice/noticeshow

		// TODO Auto-generated method stub
		int num = noticemapper.GetNoticeNum();
		List<Notice> noticeslist = noticemapper.showNoticesAll((page - 1) * rows, rows);
		PageInfo info = new PageInfo<>(noticeslist);
		long total = num;
		String jsonlist = JSON.toJSONString(noticeslist);
		String json = "{\"total\":" + total + ",\"data\":" + jsonlist + "}";
		if (noticeslist.size() != 0) {
			return json;
		}
		return null;
	}

//	@Override
//	public String findNoticeAll(String noticeContent) {
//		// TODO Auto-generated method stub
//		List<Notice> list = noticemapper.findNoticeAll(noticeContent);
//		String jsonliString = JSON.toJSONString(list);
//		String jsonreturnString = "{\"data\":" + jsonliString + "}";
//		if (list.size() != 0) {
//			return jsonreturnString;
//		}
//		return null;
//	}

	@Override // 公告的模糊查询功能，分页展示
	public String findNoticeByLike(String noticeContent, Integer page, Integer rows) {

		// 测试的url
		// http://localhost:8081/admin/notice/findNoticeByLike?noticeContent=ca&page=2&rows=1

//		PageHelper.startPage(page, rows);
		int num = noticemapper.findNoticeByLikeTotal(noticeContent);
		List<Notice> list = noticemapper.findNoticeByLike(noticeContent, (page - 1) * rows, rows);
		PageInfo info = new PageInfo<>(list);
		long total = num;
		String jsonlist = JSON.toJSONString(list);
		String json = "{\"total\":" + total + ",\"data\":" + jsonlist + "}";
		if (list.size() != 0) {
			return json;
		}
		return null;

	}

}
