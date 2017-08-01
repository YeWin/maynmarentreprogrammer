package com.mep.domain.admin.administrator.service;

import com.mep.domain.admin.administrator.dto.AdministratorDto;

public interface AdministratorUpdateConfirmService {

	boolean updateAdministrator(AdministratorDto adminDto) throws Exception;
}
