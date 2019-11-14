package com.imageshop.domain;

import java.io.Serializable;
import java.util.Date;

public class CodeClass implements Serializable {

	/* 직렬화 시켜서 Json데이터로 바꾸어준다(아래처럼 명시하면 멤버변수 추가,삭제에도 상관없음)
	 	CodeClass{classCode=' ', className=' ', useYn=' ',regDate=' ',updDate=' '}
	 
	 */
	private static final long serialVersionUID=6621378083749101963L;
	
	private String classCode;
	private String className;
	private String useYn;
	private Date regDate;
	private Date updDate;
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	
}
