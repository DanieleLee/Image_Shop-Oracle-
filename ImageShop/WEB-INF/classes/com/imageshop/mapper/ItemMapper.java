package com.imageshop.mapper;

import java.util.List;

import com.imageshop.domain.Item;

public interface ItemMapper {

	public void create(Item item) throws Exception;
	
	public List<Item> list() throws Exception;
	
	
	public Item read(Integer itemId) throws Exception;
	
	public void update(Item item) throws Exception;
	
	public void delete(Integer itemId) throws Exception;
	
	public String getPreview(Integer itemId) throws Exception;
	
}
