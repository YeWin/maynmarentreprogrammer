package com.mep.domain.admin.administrator.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorUpdateConfirmDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.util.DateUtil;

@Service
public class AdministratorUpdateConfirmServiceImpl implements
		AdministratorUpdateConfirmService {

	@Autowired
	AdministratorUpdateConfirmDao administratorUpdateConfirmDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	public boolean updateAdministrator(AdministratorDto adminDto)
			throws Exception {

		administratorUpdateConfirmDao
				.updateAdministrator(setDtoModelToEntityModel(adminDto));

		return true;
	}

	private Administrator setDtoModelToEntityModel(AdministratorDto adminDto)
			throws Exception {
		Administrator admin = new Administrator();

		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminImageUrl(adminDto.getAdminImageUrl());
		admin.setAboutAdmin(adminDto.getAboutAdmin());
		admin.setUpdatedDate(DateUtil.getCurrentTime());		

		return admin;
	}

}
