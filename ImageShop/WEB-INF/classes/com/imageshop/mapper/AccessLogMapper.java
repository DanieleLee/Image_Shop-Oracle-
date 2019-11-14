package com.imageshop.mapper;

import java.util.List;

import com.imageshop.domain.AccessLog;

public interface AccessLogMapper {

	public void create(AccessLog accessLog) throws Exception;
	
	public List<AccessLog> list() throws Exception;
}
