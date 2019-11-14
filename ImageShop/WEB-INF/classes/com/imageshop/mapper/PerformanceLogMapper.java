package com.imageshop.mapper;

import java.util.List;

import com.imageshop.domain.PerformanceLog;

public interface PerformanceLogMapper {

	public void create(PerformanceLog performanceLog) throws Exception;
	
	public List<PerformanceLog> list() throws Exception;
}
