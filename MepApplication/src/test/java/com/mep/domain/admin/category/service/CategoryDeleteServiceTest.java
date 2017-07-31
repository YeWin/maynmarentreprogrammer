package com.mep.domain.admin.category.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.util.TestAbstract;

public class CategoryDeleteServiceTest extends TestAbstract {

	@Autowired
	CategoryDeleteService categoryDeleteService;

	@Test
	public void shouldDelete() throws Exception {
		boolean flag = categoryDeleteService.categoryDelete(2);
		assertThat(flag, is(true));
	}
}
