package com.mep.util;

import com.mep.domain.admin.category.dto.CategoryDto;

public class TestServiceUtil {

	public static CategoryDto newCategoryDto() {
		
		CategoryDto categoryDto = new CategoryDto();		
		
		categoryDto.setCategoryName("Article");		
		
		return categoryDto;
	}
}
