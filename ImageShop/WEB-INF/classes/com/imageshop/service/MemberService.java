package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.Member;

public interface MemberService {
		
	public int countAll() throws Exception;
	
	public void setupAdmin(Member member) throws Exception;
	
	public void register(Member member) throws Exception;
	
	public Member read(int userNo) throws Exception;
	
	public void modify(Member member) throws Exception;
	
	public void remove(int userNo) throws Exception;
	
	public List<Member> list() throws Exception;
	
	public int getCoin(int userNo) throws Exception;
}
