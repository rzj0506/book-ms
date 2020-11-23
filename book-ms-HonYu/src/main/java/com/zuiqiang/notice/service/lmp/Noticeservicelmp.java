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
	public String showNoticesAll() {
		// TODO Auto-generated method stub
		List<Notice> noticeslist = noticemapper.showNoticesAll();
		PageInfo info = new PageInfo<>(noticeslist);
		long total = info.getTotal();
		String jsonlist = JSON.toJSONString(noticeslist);
		String json = "{\"total\":" + total + ",\"data\":" + jsonlist + "}";
		if (noticeslist.size() != 0) {
			return json;
		}
		return null;
	}

	@Override
	public Notice findNoticeAll(String noticeContent) {
		// TODO Auto-generated method stub
		return noticemapper.findNoticeAll(noticeContent);
	}

	@Override
	public String findNoticeByLike(String noticeContent, Integer page, Integer rows) {
		Notice anotice = noticemapper.findNoticeAll(noticeContent);
		List<Notice> alist = noticemapper.getHistoryBynoticeId(anotice.getNoticeId());
		PageInfo info = new PageInfo<>(alist);
		long total = info.getTotal();
		String jsonlist = JSON.toJSONString(alist);
		String json = "{\"noticeContent\":" + anotice.getNoticeContent() + ",\"total\":" + total + ",\"data\":"
				+ jsonlist + "}";
		if (alist.size() != 0) {
			return json;
		}
		return "??????";
	}

}
