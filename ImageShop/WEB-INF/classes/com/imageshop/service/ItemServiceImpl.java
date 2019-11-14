package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.Item;
import com.imageshop.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper mapper;

	@Override
	public void register(Item item) throws Exception {
		
		mapper.create(item);
	}

	@Override
	public List<Item> list() throws Exception {
		
		return mapper.list();
	}

	@Override
	public Item read(Integer itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item item) throws Exception {
		
		mapper.update(item);
	}

	@Override
	public void remove(Integer itemId) throws Exception {
		mapper.delete(itemId);
	}

	@Override
	public String getPreview(Integer itemId) throws Exception {
		return mapper.getPreview(itemId);
	}
	
	
}
