package com.mep.domain.admin.post.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Administrator;
import com.mep.util.TestAbstract;

public class AdministratorReferDaoTest extends TestAbstract {

	@Autowired
	AdministratorReferDao administratorReferDao;
	
	@Test
	public void shouldReturnAdministratorId() {
		Administrator administrator = this.administratorReferDao
				.getAdminIdByEmail("yewin@programmer.com");
		assertThat(administrator, notNullValue());
		assertThat(administrator.getAdminId(), notNullValue());
	}
}
