package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.imageshop.domain.CodeClass;
import com.imageshop.domain.CodeDetail;
import com.imageshop.mapper.CodeDetailMapper;

@Service
public class CodeDetailServiceImpl implements CodeDetailService{

	@Autowired
	private CodeDetailMapper mapper;

	@Override
	public void registr(CodeDetail codeDetail) throws Exception {
		
		
	}

	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		
		return mapper.read(codeDetail);
	}

	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		mapper.update(codeDetail);
		
	}

	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		mapper.delete(codeDetail);
		
	}

	@Override
	public List<CodeDetail> list() throws Exception {
		
		return mapper.list();
	}
}
