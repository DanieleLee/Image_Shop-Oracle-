package com.imageshop.service;

import java.util.List;

import com.imageshop.domain.ChargeCoin;
import com.imageshop.domain.PayCoin;

public interface CoinService {

	public void charge(ChargeCoin chargeCoin) throws Exception;


	public List<ChargeCoin> list(int userNo) throws Exception;
	
	public List<PayCoin> listPayHistory(int userNo) throws Exception;
}
