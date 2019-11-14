package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.CodeClass;
import com.imageshop.domain.CodeDetail;

public interface CodeDetailService {

	public void registr(CodeDetail codeDetail) throws Exception;
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
	public void modify(CodeDetail codeDetail) throws Exception;
	public void remove(CodeDetail codeDetail) throws Exception;
	public List<CodeDetail> list() throws Exception;
}
