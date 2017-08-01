package com.mep.domain.admin.administrator.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorUpdateDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;

@Service
public class AdministratorUpdateServiceImpl implements
		AdministratorUpdateService {

	@Autowired
	AdministratorUpdateDao administratorUpdateDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	public AdministratorDto getAdministratorById(Integer adminId)
			throws Exception {

		Administrator admin = administratorUpdateDao
				.getAdministratorById(adminId);

		return setEntityModelToDtoModel(admin);
	}

	private AdministratorDto setEntityModelToDtoModel(Administrator admin) {
		AdministratorDto adminDto = new AdministratorDto();

		adminDto.setAdminId(admin.getAdminId());
		adminDto.setAdminName(admin.getAdminName());
		adminDto.setAdminEmail(admin.getAdminEmail());

		return adminDto;
	}

}
