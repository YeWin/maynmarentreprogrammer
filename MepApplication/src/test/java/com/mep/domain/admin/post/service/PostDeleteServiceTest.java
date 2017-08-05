package com.mep.domain.admin.post.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.util.TestAbstract;

public class PostDeleteServiceTest extends TestAbstract {

	@Autowired
	PostDeleteService postDeleteService;

	@Test
	public void shouldDelete() throws Exception {
		boolean flag = postDeleteService.postDelete(10);
		assertThat(flag, is(true));
	}

}
