package com.imageshop.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.imageshop.domain.Member;
import com.imageshop.mapper.MemberMapper;
import com.imageshop.security.domain.CustomUser;

public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger=LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.warn("Load User By UserName:"+username);
		
		//userName means userid
		Member member=memberMapper.readByUserId(username);
		logger.warn("queried by member mapper:"+member);
		return member==null ? null: new CustomUser(member);
	}

}
