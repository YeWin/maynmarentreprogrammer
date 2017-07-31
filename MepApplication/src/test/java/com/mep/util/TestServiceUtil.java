package com.mep.util;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.domain.admin.category.dto.CategoryDto;

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

		return adminDto;
	}
}
