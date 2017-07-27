package com.mep.domain.admin.category.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.util.TestAbstract;

public class CategoryDeleteDaoTest extends TestAbstract {

	@Autowired
	private CategoryDeleteDao categoryDeleteDao;
	
	@Test
	public void shouldDelete() {		
		int count = this.categoryDeleteDao.categoryDelete(2);
		assertThat(count, is(1));		
	}
}
