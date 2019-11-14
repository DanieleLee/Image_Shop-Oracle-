package com.imageshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.LoginLog;
import com.imageshop.mapper.LoginLogMapper;

@Service
public class LoginLogServiceImpl implements LoginLogService {

	
	@Autowired
	private LoginLogMapper mapper;

	@Override
	public void register(LoginLog loginLog) throws Exception {
			
		mapper.create(loginLog);
	}
}
