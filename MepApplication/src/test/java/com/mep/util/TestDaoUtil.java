package com.mep.util;

import com.mep.database.entity.Administrator;
import com.mep.database.entity.Category;

public class TestDaoUtil {

	public static Category newCategory() {

		Category category = new Category();

		category.setCategoryName("Article");

		return category;
	}

	public static Administrator newAdministrator() {

		Administrator admin = new Administrator();

		admin.setAdminName("Ye Win");
		admin.setAdminEmail("yewin29081990@gmail.com");

		return admin;
	}
}
