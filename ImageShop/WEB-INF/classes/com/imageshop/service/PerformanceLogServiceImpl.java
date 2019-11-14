package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.PerformanceLog;
import com.imageshop.mapper.PerformanceLogMapper;

@Service
public class PerformanceLogServiceImpl implements PerformanceLogService{

	@Autowired
	PerformanceLogMapper mapper;
	
	@Override
	public void register(PerformanceLog performanceLog) throws Exception {
		mapper.create(performanceLog);
	}

	@Override
	public List<PerformanceLog> list() throws Exception {
		return mapper.list();
	}

}
