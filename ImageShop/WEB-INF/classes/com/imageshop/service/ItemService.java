package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.Item;

public interface ItemService  {

	public void register(Item item) throws Exception;
	
	public List<Item> list() throws Exception;
	
	public Item read(Integer itemId) throws Exception;
	
	public void modify(Item item) throws Exception;
	
	public void remove(Integer itemId) throws Exception;
	
	public String getPreview(Integer itemId) throws Exception;
}
