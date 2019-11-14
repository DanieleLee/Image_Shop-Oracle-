package com.imageshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imageshop.domain.CodeDetail;
import com.imageshop.security.domain.CodeLabelValue;
import com.imageshop.service.CodeDetailService;
import com.imageshop.service.CodeService;

@Controller
@RequestMapping("/codedetail")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CodeDetailController {
	
	@Autowired
	private CodeDetailService codeDetailService;

	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public void registerForm(Model model) throws Exception {
		CodeDetail codeDetail=new CodeDetail();
		model.addAttribute(codeDetail);
		
		List<CodeLabelValue> classCodeList=codeService.getCodeClassList();
		model.addAttribute("classCodeList", classCodeList);
	
	}

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(CodeDetail codeDetail,RedirectAttributes rttr) throws Exception {
		codeDetailService.registr(codeDetail);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/codedetail/list";
	}

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list",codeDetailService.list());
	}
	
	
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void read(CodeDetail codeDetail,Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		
		List<CodeLabelValue> classCodeList=codeService.getCodeClassList();
		model.addAttribute("classCodeList", classCodeList);
	
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(CodeDetail codeDetail,RedirectAttributes rttr) throws Exception {
		
		codeDetailService.remove(codeDetail);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/codedetail/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(CodeDetail codeDetail,Model model) throws Exception {
		
		model.addAttribute(codeDetailService.read(codeDetail));
		
		List<CodeLabelValue> classCodeList=
				codeService.getCodeClassList();
		model.addAttribute("classCodeList",classCodeList);
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(CodeDetail codeDetail,RedirectAttributes rttr) throws Exception {
		
		codeDetailService.modify(codeDetail);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/codedetail/list";
		
	}
	
}
