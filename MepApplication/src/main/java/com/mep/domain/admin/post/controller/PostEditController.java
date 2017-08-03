package com.mep.domain.admin.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.service.PostInitService;
import com.mep.domain.admin.post.service.PostInsertService;
import com.mep.message.MessageHelper;

@Controller
@RequestMapping("/admin/*")
@RequestScope
public class PostEditController extends PostEditControllerHelper {

	private static final String INPUT_PATH = "/admin/post/postInput";

	private static final String INPUT_COMPLETE_PATH = "/admin/post/postInputComplete";
	
	@Autowired
	PostInitService postInitService;
	
	@Autowired
	PostInsertService postInsertService;
	
	@Autowired
	private MessageHelper messageHelper;
	
	@GetMapping(value = "/post/insert")
	public ModelAndView init() throws Exception {

		ModelAndView mav = new ModelAndView(INPUT_PATH);
		
		PostDto postDto = new PostDto(); 
				
		postDto = setCategoryDropdownToPostDtoObject(postInitService, postDto);		
		
		mav.addObject("postDto", postDto);
		
		return mav;
	}
	
	@PostMapping(value = "/post/insertConfirm")
	public @ResponseBody ModelAndView postInsert(
			@Validated @ModelAttribute("postDto") PostDto postDto,
			BindingResult bindingResult, ModelMap model) throws Exception {

		ModelAndView mav = new ModelAndView(INPUT_COMPLETE_PATH);
		mav.addObject(postDto);

		if (bindingResult.hasErrors()) {			
			postDto = setCategoryDropdownToPostDtoObject(postInitService, postDto);
			mav.setViewName(INPUT_PATH);
			return mav;
		}

		postInsertService.insertPost(postDto);

		messageHelper.setCompleteMessage(mav, "MSP0001");

		return mav;
	}
	 
}
