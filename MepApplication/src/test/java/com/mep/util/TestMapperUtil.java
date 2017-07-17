package com.mep.util;

import com.mep.database.entity.Category;

public class TestMapperUtil {

	public static Category newCategory() {
		
		Category category = new Category();
		
		category.setCategoryName("Article");
		
		return category;
	}
}
