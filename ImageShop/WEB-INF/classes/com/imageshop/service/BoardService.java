package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.Board;
import com.imageshop.domain.PageRequest;

public interface BoardService {

	public void register(Board board) throws Exception;
	
	public Board read(Integer boardNo) throws Exception;
	
	public void modify(Board board) throws Exception;
	
	public void remove(Integer boardNo) throws Exception;
	
	public List<Board> list(PageRequest pageRequest) throws Exception;

	public int count(PageRequest pageRequest) throws Exception;
}
