package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.Item;
import com.imageshop.domain.Member;
import com.imageshop.domain.UserItem;

public interface UserItemService {

	public void register(Member member,Item item) throws Exception;

	public List<UserItem> list(Integer userNo) throws Exception;
	
	public UserItem read(Integer userItemNo) throws Exception;
	
	public List<UserItem> listAll() throws Exception;
	
	
	
	
	
}
