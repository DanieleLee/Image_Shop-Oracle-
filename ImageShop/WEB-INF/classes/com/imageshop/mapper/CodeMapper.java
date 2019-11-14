package com.imageshop.mapper;

import java.util.List;

import com.imageshop.security.domain.CodeLabelValue;



public interface CodeMapper {
	
	public List<CodeLabelValue> getCodeClassList() throws Exception;

	public List<CodeLabelValue> getCodeList(String classCode) throws Exception;
	
}
