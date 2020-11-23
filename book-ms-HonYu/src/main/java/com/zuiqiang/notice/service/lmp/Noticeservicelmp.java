package com.zuiqiang.notice.service.lmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
