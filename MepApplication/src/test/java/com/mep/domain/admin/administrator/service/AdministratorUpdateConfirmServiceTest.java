package com.mep.domain.admin.administrator.service;

import static com.mep.util.TestServiceUtil.newAdministratorDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.util.TestAbstract;

public class AdministratorUpdateConfirmServiceTest extends TestAbstract {

	@Autowired
	private AdministratorUpdateConfirmService administratorUpdateConfirmService;

	@Test
	public void shouldUpdate() throws Exception {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminId(2);
		adminDto.setAdminEmail("yewin@gmail.com");
		boolean flag = this.administratorUpdateConfirmService
				.updateAdministrator(adminDto);
		assertThat(flag, is(true));
	}
}
