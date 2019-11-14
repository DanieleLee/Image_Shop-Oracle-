package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.AccessLog;
import com.imageshop.mapper.AccessLogMapper;

@Service
public class AccessLogServiceImpl implements AccessLogService {

	@Autowired
	private AccessLogMapper mapper;
	
	@Override
	public void register(AccessLog accessLog) throws Exception {
		mapper.create(accessLog);
		
	}

	@Override
	public List<AccessLog> list() throws Exception {
		return mapper.list();
	}

}
