package com.mep.database.mapper.category;

import static com.mep.util.TestMapperUtil.newCategory;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Category;
import com.mep.database.mapper.CategoryMapper;
import com.mep.util.TestAbstract;

public class CategoryUpdateConfirmMapperTest extends TestAbstract {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void shouldUpdate() {
		Category category = newCategory();
		category.setCategoryId(3);
		category.setCategoryName("Java Best Practice");
		int count = this.categoryMapper.updateByPrimaryKeySelective(category);
		assertThat(count, is(1));		
	}
}
