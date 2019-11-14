package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.Notice;
import com.imageshop.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper mapper;

	@Override
	public void register(Notice notice) throws Exception {
		mapper.create(notice);
	}

	@Override
	public List<Notice> list() throws Exception {
		
		return mapper.list();
	}

	@Override
	public Notice read(Integer noticeNo) throws Exception {
		
		return mapper.read(noticeNo);
	}

	@Override
	public void modify(Notice notice) throws Exception {
		mapper.update(notice);
		
	}

	@Override
	public void remove(Integer noticeNo) throws Exception {
		mapper.delete(noticeNo);
		
	}
}
