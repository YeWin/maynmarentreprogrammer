package com.mep.database.mapper.category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.mapper.CategoryMapper;
import com.mep.util.TestAbstract;

public class CategoryDeleteMapperTest extends TestAbstract {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void shouldDelete() {		
		int count = this.categoryMapper.deleteByPrimaryKey(1);
		assertThat(count, is(1));		
	}
}
