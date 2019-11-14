package com.imageshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imageshop.domain.Item;
import com.imageshop.domain.Member;
import com.imageshop.domain.PayCoin;
import com.imageshop.domain.UserItem;
import com.imageshop.exception.NotEnoughCoinException;
import com.imageshop.mapper.CoinMapper;
import com.imageshop.mapper.UserItemMapper;

@Service
public class UserItemServiceImpl implements UserItemService {

	@Autowired
	private UserItemMapper mapper;
	
	@Autowired
	private CoinMapper coinMapper;

	@Transactional
	@Override
	public void register(Member member, Item item) throws Exception {
		int userNo=member.getUserNo();
		int itemId=item.getItemId();
		int price=item.getPrice();
		int coin=member.getCoin();
		
		UserItem userItem=new UserItem();
		userItem.setUserNo(userNo);
		userItem.setItemId(itemId);
		
		if(coin<price) {
			throw new NotEnoughCoinException("There is Not Enough");
		}
		
		PayCoin payCoin=new PayCoin();
		payCoin.setUserNo(userNo);
		payCoin.setItemId(itemId);
		payCoin.setAmount(price);
		
		coinMapper.pay(payCoin);
		coinMapper.createPayHistory(payCoin);
		
		mapper.create(userItem);
		
	}

	@Override
	public List<UserItem> list(Integer userNo) throws Exception {
		
		return mapper.list(userNo);
	}

	@Override
	public UserItem read(Integer userItemNo) throws Exception {
		
		return mapper.read(userItemNo);
	}

	@Override
	public List<UserItem> listAll() throws Exception {
		return mapper.listAll();
	}
}
