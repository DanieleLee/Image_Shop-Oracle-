package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.PerformanceLog;

public interface PerformanceLogService {

	public void register(PerformanceLog performanceLog) throws Exception;
	
	public List<PerformanceLog> list() throws Exception;
}
