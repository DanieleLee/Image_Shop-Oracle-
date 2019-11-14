package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.AccessLog;

public interface AccessLogService {

	public void register(AccessLog accessLog) throws Exception;

	public List<AccessLog> list() throws Exception;
}
