package com.mep.domain.admin.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.domain.admin.category.service.CategoryDeleteService;
import com.mep.domain.admin.category.service.CategoryInsertService;
import com.mep.domain.admin.category.service.CategoryUpdateConfirmService;
import com.mep.domain.admin.category.service.CategoryUpdateService;
import com.mep.message.MessageHelper;

@Controller
@RequestMapping("/admin/*")
public class CategoryEditController {
	
	@Autowired
	CategoryInsertService categoryInsertService;
	
	@Autowired
	CategoryDeleteService categoryDeleteService;
	
	@Autowired
	CategoryUpdateService categoryUpdateService;
	
	@Autowired
	CategoryUpdateConfirmService categoryUpdateConfirmService;
	
	@Autowired
	private MessageHelper messageHelper;

	@GetMapping(value = "/category/insert")
	public ModelAndView admin() {

		ModelAndView mav = new ModelAndView("/admin/category/categoryInput");
		mav.addObject("categoryDto", new CategoryDto());
		return mav;
	}
	
	@PostMapping(value = "/category/insertConfirm")
	public @ResponseBody ModelAndView categoryInsert(
			@Validated @ModelAttribute("categoryDto") CategoryDto categoryDto,
			BindingResult bindingResult) throws Exception {

		ModelAndView mav = new ModelAndView("/admin/category/categoryInsertComplete");
		mav.addObject(categoryDto);

		if (bindingResult.hasErrors()) {
			mav.setViewName("/admin/category/categoryInput");
			return mav;
		}

		categoryInsertService.insertCategory(categoryDto);

		messageHelper.setCompleteMessage(mav, "MSP0001");

		return mav;
	}
	
	@GetMapping(value = "/category/update")
	public ModelAndView categoryUpdate(@ModelAttribute("categoryId") Integer categoryId)
			throws Exception {

		ModelAndView mav = new ModelAndView("/admin/category/categoryUpdate");

		CategoryDto categoryDto = categoryUpdateService.getCategoryById(categoryId);

		mav.addObject(categoryDto);

		return mav;
	}
	
	@PostMapping(value = "/category/updateConfirm")
	public ModelAndView categoryUpdateConfirm(
			@Validated @ModelAttribute("categoryDto") CategoryDto categoryDto,
			BindingResult bindingResult) throws Exception {

		ModelAndView mav = new ModelAndView("/admin/category/categoryUpdateComplete");
		mav.addObject(categoryDto);

		if (bindingResult.hasErrors()) {
			mav.setViewName("/admin/category/categoryUpdate");
			return mav;
		}

		categoryUpdateConfirmService.updateCategory(categoryDto);

		messageHelper.setCompleteMessage(mav, "MSP0001");

		return mav;
	}
	
	@GetMapping(value = "/category/delete/{categoryId}")
	public String categoryDelete(@PathVariable("categoryId") Integer categoryId)
			throws Exception {

		categoryDeleteService.categoryDelete(categoryId);

		String redirectPage = "redirect:/admin/category/";

		return redirectPage;
	}
}
