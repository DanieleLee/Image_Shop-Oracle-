package com.imageshop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imageshop.domain.Item;
import com.imageshop.domain.Member;
import com.imageshop.domain.UserItem;
import com.imageshop.exception.NotMyItemException;
import com.imageshop.security.domain.CustomUser;
import com.imageshop.service.ItemService;
import com.imageshop.service.UserItemService;

@Controller
@RequestMapping("/useritem")
public class UserItemController {

	@Autowired
	private UserItemService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/listAll",method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list",service.listAll());
	}
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void list(Model model,Authentication authentication) throws Exception{
		
		CustomUser customUser=(CustomUser) authentication.getPrincipal();
		Member member=customUser.getMember();
		
		int userNo=member.getUserNo();
		
		model.addAttribute("list",service.list(userNo));
	
	
	}
	
	
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void read(int userItemNo,Model model) throws Exception{
		model.addAttribute(service.read(userItemNo));
	}
	
	
	@ResponseBody
	@RequestMapping("/download")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public ResponseEntity<byte[]> download(int userItemNo,Authentication authentication) throws Exception{
		UserItem userItem=service.read(userItemNo);
	
		CustomUser customUser=(CustomUser) authentication.getPrincipal();
		Member member=customUser.getMember();
		
		if(userItem.getUserNo()!=member.getUserNo()) {
			throw new NotMyItemException("It is Not My Item");
		}
		
		String fullName=userItem.getPictureUrl();
		
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		
		try {
			HttpHeaders headers=new HttpHeaders();
			
			in=new FileInputStream(uploadPath+File.separator+fullName);
			
			String fileName=fullName.substring(fullName.indexOf("_")+1);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
	
			entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
			return entity;
	}
	
	
	@RequestMapping(value = "/notMyItem",method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void notMyItem(Model model) throws Exception{
		
	}
	
	
}
