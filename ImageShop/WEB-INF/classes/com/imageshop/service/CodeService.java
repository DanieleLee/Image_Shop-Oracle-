package com.imageshop.service;


import java.util.List;
import com.imageshop.domain.CodeClass;
import com.imageshop.security.domain.CodeLabelValue;

public interface CodeService {

	public List<CodeLabelValue> getCodeClassList() throws Exception;
	
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception;
}
