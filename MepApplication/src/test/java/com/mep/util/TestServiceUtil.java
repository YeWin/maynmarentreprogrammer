package com.mep.util;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.domain.admin.post.dto.PostDto;

public class TestServiceUtil {

	public static CategoryDto newCategoryDto() {

		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setCategoryName("Article");

		return categoryDto;
	}

	public static AdministratorDto newAdministratorDto() {

		AdministratorDto adminDto = new AdministratorDto();

		adminDto.setAdminName("Ye Win");
		adminDto.setAdminEmail("yewin29081990@gmail.com");
		adminDto.setAdminImageUrl("URL");
		adminDto.setAboutAdmin("About author");

		return adminDto;
	}

	public static PostDto getSearchCriteriaPostDto() {
		PostDto postDto = new PostDto();

		postDto.setCategoryId(2);
		postDto.setPostTitleEng("");

		return postDto;
	}
}
