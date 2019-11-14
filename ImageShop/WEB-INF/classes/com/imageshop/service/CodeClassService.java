package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.CodeClass;

public interface CodeClassService {

	public void registr(CodeClass codeClass) throws Exception;
	public CodeClass read(String classCode) throws Exception;
	public void modify(CodeClass codeClass) throws Exception;
	public void remove(String classCode) throws Exception;
	public List<CodeClass> list() throws Exception;

}
