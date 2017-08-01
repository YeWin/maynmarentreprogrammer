package com.mep.domain.admin.administrator.controller;

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

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.domain.admin.administrator.service.AdministratorDeleteService;
import com.mep.domain.admin.administrator.service.AdministratorInsertService;
import com.mep.message.MessageHelper;
import com.mep.message.ResultMessages;

@Controller
@RequestMapping("/admin/*")
public class AdministratorEditController {

	private static final String INPUT_PATH = "/admin/administrator/administratorInput";

	private static final String INPUT_COMPLETE_PATH = "/admin/administrator/administratorInputComplete";

	@Autowired
	AdministratorInsertService administratorInsertService;

	@Autowired
	AdministratorDeleteService administratorDeleteService;

	@Autowired
	private MessageHelper messageHelper;

	@GetMapping(value = "/administrator/insert")
	public ModelAndView init() {

		ModelAndView mav = new ModelAndView(INPUT_PATH);
		mav.addObject("adminDto", new AdministratorDto());
		return mav;
	}

	@PostMapping(value = "/administrator/insertConfirm")
	public @ResponseBody ModelAndView administratorInsert(
			@Validated @ModelAttribute("adminDto") AdministratorDto adminDto,
			BindingResult bindingResult) throws Exception {

		ModelAndView mav = new ModelAndView(INPUT_COMPLETE_PATH);
		mav.addObject(adminDto);

		if (bindingResult.hasErrors()) {
			mav.setViewName(INPUT_PATH);
			return mav;
		}

		ResultMessages resultMessages = administratorInsertService
				.validate(adminDto);

		if (!resultMessages.getErrorList().isEmpty()) {
			mav.addObject("resultMessages", resultMessages);
			mav.setViewName(INPUT_PATH);
			return mav;
		}

		administratorInsertService.insertAdministrator(adminDto);

		messageHelper.setCompleteMessage(mav, "MSP0001");

		return mav;
	}

	@GetMapping(value = "/administrator/delete/{adminId}")
	public String administratorDelete(@PathVariable("adminId") Integer adminId)
			throws Exception {

		administratorDeleteService.admnistratorDelete(adminId);

		return "redirect:/admin/";
	}
}
