package com.mep.domain.admin.category.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Category;
import com.mep.util.TestAbstract;

public class CategoryListDaoTest extends TestAbstract {

	@Autowired
	private CategoryListDao categoryListDao;

	@Test
	public void shouldReturnCategoryList() {
		List<Category> category = this.categoryListDao.getCategoryList();
		assertThat(category, notNullValue());
		assertThat(category.size(), anyOf(greaterThan(-1), is(not(0))));
	}
}
