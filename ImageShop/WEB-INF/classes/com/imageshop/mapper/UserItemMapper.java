package com.imageshop.mapper;

import java.util.List;

import com.imageshop.domain.UserItem;

public interface UserItemMapper {

	public void create(UserItem userItem) throws Exception;
	
	public List<UserItem> list(Integer userNo) throws Exception;
	public List<UserItem> listAll() throws Exception;
	
	public UserItem read(Integer userItemNo) throws Exception;
	
}
