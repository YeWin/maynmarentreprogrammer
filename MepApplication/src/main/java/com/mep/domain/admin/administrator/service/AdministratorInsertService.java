package com.mep.domain.admin.administrator.service;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.ResultMessages;

public interface AdministratorInsertService {

	ResultMessages validate(AdministratorDto adminDto);
	
	boolean insertAdministrator(AdministratorDto adminDto) throws Exception;
}
