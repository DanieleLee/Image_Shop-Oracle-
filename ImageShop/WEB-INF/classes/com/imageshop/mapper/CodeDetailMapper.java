package com.imageshop.mapper;

import java.util.List;

import com.imageshop.domain.CodeDetail;



public interface CodeDetailMapper {

	public void create(CodeDetail codeDetail) throws Exception;

	public CodeDetail read(CodeDetail codeDetail) throws Exception;

	public void update(CodeDetail codeDetail) throws Exception;

	public void delete(CodeDetail codeDetail) throws Exception;

	public List<CodeDetail> list() throws Exception;
	
	public Integer getMaxSortSeq(String classCode) throws Exception;

}
