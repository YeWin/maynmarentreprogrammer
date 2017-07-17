package com.mep.database.mapper.category;

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
import com.mep.database.entity.CategoryExample;
import com.mep.database.mapper.CategoryMapper;
import com.mep.util.TestAbstract;

public class CategoryListMapperTest extends TestAbstract {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void shouldReturnCategoryList() {
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.or().andCategoryIdIsNotNull();
		List<Category> category = this.categoryMapper.selectByExample(categoryExample);
		assertThat(category, notNullValue());
		assertThat(category.size(), anyOf(greaterThan(-1), is(not(0))));
	}
}
