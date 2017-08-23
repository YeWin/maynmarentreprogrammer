package com.mep.domain.admin.post.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mep.domain.admin.post.dto.CategoryDropdownDto;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.service.PostInitService;
import com.mep.domain.login.dto.SessionLoginAdminDto;
import com.mep.util.Constant;

public abstract class PostControllerHelper {

	protected PostDto setCategoryDropdownToPostDtoObject(
			PostInitService postInitService, PostDto postDto) throws Exception {

		List<CategoryDropdownDto> categoryDropdownDto = postInitService
				.getCategoryDropdown();

		postDto.setCategoryDropdown(categoryDropdownDto);

		return postDto;

	}

	protected Integer getAdminIdFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionLoginAdminDto sessionDto = (SessionLoginAdminDto) session
				.getAttribute(Constant.SESSION_KEY);

		return sessionDto.getAdminId();
	}
}
