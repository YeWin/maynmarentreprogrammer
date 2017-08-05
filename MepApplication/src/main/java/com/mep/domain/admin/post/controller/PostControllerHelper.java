package com.mep.domain.admin.post.controller;

import java.util.List;

import com.mep.domain.admin.post.dto.CategoryDropdownDto;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.service.PostInitService;

public abstract class PostControllerHelper {

	public PostDto setCategoryDropdownToPostDtoObject(PostInitService postInitService,
			PostDto postDto) throws Exception {

		List<CategoryDropdownDto> categoryDropdownDto = postInitService
				.getCategoryDropdown();

		postDto.setCategoryDropdown(categoryDropdownDto);

		return postDto;

	}
}
