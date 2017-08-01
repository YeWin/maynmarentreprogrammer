package com.mep.domain.admin.administrator.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.util.TestAbstract;

public class AdministratorDeleteServiceTest extends TestAbstract {

	@Autowired
	AdministratorDeleteService administratorDeleteService;

	@Test
	public void shouldDelete() throws Exception {
		boolean flag = administratorDeleteService.admnistratorDelete(1);
		assertThat(flag, is(true));
	}
}