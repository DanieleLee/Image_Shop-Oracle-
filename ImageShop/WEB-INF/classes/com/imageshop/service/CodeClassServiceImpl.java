package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.CodeClass;
import com.imageshop.mapper.CodeClassMapper;

@Service
public class CodeClassServiceImpl implements CodeClassService{
	
	@Autowired
	private CodeClassMapper mapper;

	@Override
	public void registr(CodeClass codeClass) throws Exception {
		mapper.create(codeClass);
		
	}

	@Override
	public CodeClass read(String classCode) throws Exception {
		CodeClass code =mapper.read(classCode);
		System.out.println("결과!!!:"+code.getClassCode());
		
		return mapper.read(classCode);
	}

	@Override
	public void modify(CodeClass codeClass) throws Exception {
		
		mapper.update(codeClass);
		
	}

	@Override
	public void remove(String classCode) throws Exception {
		mapper.delete(classCode);
		
	}

	@Override
	public List<CodeClass> list() throws Exception {
		System.out.println("list>>>"+mapper.list());
		return mapper.list();
	}

	

}
