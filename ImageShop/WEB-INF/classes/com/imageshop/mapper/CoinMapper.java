package com.imageshop.mapper;

import java.util.List;

import com.imageshop.domain.ChargeCoin;
import com.imageshop.domain.PayCoin;

public interface CoinMapper {

	public void create(ChargeCoin chargeCoin) throws Exception;

	public void charge(ChargeCoin chargeCoin) throws Exception;

	public List<ChargeCoin> list(int userNo) throws Exception;
	
	// 구매 내역을 생성
	public void createPayHistory(PayCoin payCoin) throws Exception;
	
	// 상품 구매에 대한 코인 지급을 처리
	public void pay(PayCoin payCoin) throws Exception;
	
	// 구매 내역을 반환
	public List<PayCoin> listPayHistory(int userNo) throws Exception;
	
	
}
