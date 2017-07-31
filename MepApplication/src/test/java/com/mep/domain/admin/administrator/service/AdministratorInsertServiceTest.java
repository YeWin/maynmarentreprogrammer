package com.mep.domain.admin.administrator.service;

import static com.mep.util.TestServiceUtil.newAdministratorDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.ResultMessages;
import com.mep.util.TestAbstract;

public class AdministratorInsertServiceTest extends TestAbstract {

	@Autowired
	private AdministratorInsertService administratorInsertService;

	@Test
	public void validateTest() {
		AdministratorDto adminDto = newAdministratorDto();
		
		ResultMessages result1 = this.administratorInsertService.validate(adminDto);
		assertThat(result1.getErrorList().isEmpty(), is(false));
		
		adminDto.setAdminPassword("12TD");
		ResultMessages result2 = this.administratorInsertService.validate(adminDto);
		assertThat(result2.getErrorList().isEmpty(), is(false));
		
		adminDto.setAdminPassword("TECHadmin12#$");
		adminDto.setAdminConfirmPassword("TECHadmin12#$12");
		
		ResultMessages result3 = this.administratorInsertService.validate(adminDto);
		assertThat(result3.getErrorList().isEmpty(), is(false));
	}

	@Test
	public void shouldInsert() throws Exception {
		AdministratorDto adminDto = newAdministratorDto();
		adminDto.setAdminPassword("123456");
		boolean flag = this.administratorInsertService.insertAdministrator(adminDto);
		assertThat(flag, is(true));
	}
}
