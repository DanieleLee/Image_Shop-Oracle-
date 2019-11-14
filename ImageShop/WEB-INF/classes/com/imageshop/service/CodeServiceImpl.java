package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.CodeClass;
import com.imageshop.mapper.CodeMapper;
import com.imageshop.security.domain.CodeLabelValue;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeMapper mapper;

	@Override
	public List<CodeLabelValue> getCodeClassList() throws Exception {
		
		return mapper.getCodeClassList();
	}

	@Override
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception {
		
		return mapper.getCodeList(classCode);
	}
	
	
	

}
