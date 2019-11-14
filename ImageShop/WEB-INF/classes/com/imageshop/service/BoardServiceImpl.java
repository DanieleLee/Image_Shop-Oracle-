package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageshop.domain.Board;
import com.imageshop.domain.PageRequest;
import com.imageshop.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(Board board) throws Exception {
			mapper.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
			mapper.update(board);
		
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
			mapper.delete(boardNo);
		
	}

	

	@Override
	public List<Board> list(PageRequest pageRequest) throws Exception {
		
		return mapper.list(pageRequest);
	}

	@Override
	public int count(PageRequest pageRequest) throws Exception {
		
		return mapper.count(pageRequest);
	}

}
