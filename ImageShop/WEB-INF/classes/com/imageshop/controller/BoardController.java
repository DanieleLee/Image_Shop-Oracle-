package com.imageshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imageshop.domain.Board;
import com.imageshop.domain.Member;
import com.imageshop.domain.PageRequest;
import com.imageshop.domain.Pagination;
import com.imageshop.security.domain.CodeLabelValue;
import com.imageshop.security.domain.CustomUser;
import com.imageshop.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void registerForm(Model model,Authentication authentication) {
		CustomUser customUser=(CustomUser) authentication.getPrincipal();
		Member member=customUser.getMember();
	
		Board board=new Board();
	
		board.setWriter(member.getUserId());
	
		model.addAttribute(board);
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String register(Board board,RedirectAttributes rttr) throws Exception {
		
		service.register(board);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public void list(Model model,@ModelAttribute("pgrq") PageRequest pageRequest) throws Exception {
		//페이징요청 정보를 매개변수로받고 다시 뷰에전달
		// 뷰에 페이징 처리를한 게시글 목록을 전달
		model.addAttribute("list",service.list(pageRequest));
		
		// 페이징 네비게이션 정보를 뷰에 전달
		Pagination pagination=new Pagination();
		pagination.setPageRequest(pageRequest);
		
		pagination.setTotalCount(service.count(pageRequest));
		model.addAttribute("pagination",pagination);
		
		// 검색유형의 코드명, 코드값을 정의
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("n", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "Title"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("w", "Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "Title OR Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("cw", "Content OR Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tcw", "Title OR Content OR Writer"));
	
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}
	
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void read(int boardNo,Model model,@ModelAttribute("pgrq") PageRequest pageRequest ) throws Exception {
		
		//조회한 게시글 상세정보를 뷰에 전달
		Board board=service.read(boardNo);
		board.setPageRequest(pageRequest);
		model.addAttribute(board);
	}
	
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public String remove(int boardNo,PageRequest pageRequest ,RedirectAttributes rttr) throws Exception {
		service.remove(boardNo);
		
		//RedirectAttributes 객체에 일회성 데이터를 지정하여 전달
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage",pageRequest.getSizePerPage());
		
		// 검색유형과 검색어를 뷰에 전달
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modifyForm(int boardNo,@ModelAttribute("pgrq") PageRequest pageRequest,Model model) throws Exception {
		
		// 조회한 게시글 상세정보를 뷰에 전달한다.
		Board board=service.read(boardNo);
		board.setPageRequest(pageRequest);
		model.addAttribute(board);
	}
	
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public String modify(Board board,PageRequest pageRequest,RedirectAttributes rttr) throws Exception {
		
		//RedirectAttributes 객체에 일회성 데이터를 지정해서 전달한다.
		rttr.addAttribute("page",pageRequest.getPage());
		rttr.addAttribute("sizePerPage",pageRequest.getSizePerPage());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}


}
