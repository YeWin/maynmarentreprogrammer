package com.mep.database.mapper.category;

import static com.mep.util.TestMapperUtil.newCategory;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Category;
import com.mep.database.mapper.CategoryMapper;
import com.mep.util.TestAbstract;

public class CategoryInsertMapperTest extends TestAbstract {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void shouldInsert() {
		Category category = newCategory();
		int count = this.categoryMapper.insertSelective(category);
		assertThat(count, is(1));		
	}

	@Test(expected = Exception.class)
	public void databaseError() {
		Category category = new Category();
		category.setCategoryId(3);
		this.categoryMapper.insertSelective(category);
	}
}
