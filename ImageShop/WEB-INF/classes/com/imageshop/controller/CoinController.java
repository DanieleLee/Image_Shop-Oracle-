package com.imageshop.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imageshop.domain.ChargeCoin;
import com.imageshop.domain.Member;
import com.imageshop.security.domain.CustomUser;
import com.imageshop.service.CoinService;

@Controller
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	private CoinService service;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(value = "/charge",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void chargeForm(Model model) throws Exception{
		ChargeCoin chargeCoin=new ChargeCoin();
	
		chargeCoin.setAmount(1000);
	
		model.addAttribute(chargeCoin);
	
	}
	
	@RequestMapping(value = "/charge",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String charge(int amount,RedirectAttributes rttr,Authentication authentication) throws Exception{
		
		CustomUser customUser=(CustomUser) authentication.getPrincipal();
		Member member=customUser.getMember();
	
		int userNo=member.getUserNo();
		
		ChargeCoin chargeCoin=new ChargeCoin();
		
		chargeCoin.setUserNo(userNo);
		chargeCoin.setAmount(amount);
		
		service.charge(chargeCoin);
		
		String message = messageSource.getMessage("coin.chargingComplete", null, Locale.KOREAN);
		rttr.addFlashAttribute("msg",message);
		
		return "redirect:/coin/success";
	
	}


	@RequestMapping(value = "/success",method = RequestMethod.GET)
	public String success() throws Exception{
		return "coin/success";
	}


	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void list(Model model,Authentication authentication) throws Exception{
		CustomUser customUser=(CustomUser) authentication.getPrincipal();
		Member member=customUser.getMember();
		
		int userNo=member.getUserNo();
		
		model.addAttribute("list",service.list(userNo));
	
	}


	@RequestMapping(value = "/notEnoughCoin",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void notEnoughCoin(Model model) throws Exception{
		
	}
	
}
