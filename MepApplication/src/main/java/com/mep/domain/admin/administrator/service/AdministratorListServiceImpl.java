package com.mep.domain.admin.administrator.service;

import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorListDao;
import com.mep.domain.admin.administrator.dto.AdministratorListDto;
import com.mep.log.ApplyAspect;

@Service
public class AdministratorListServiceImpl implements AdministratorListService {

	@Autowired
	private AdministratorListDao administratorListDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public List<AdministratorListDto> getAdministratorList() throws Exception {

		List<Administrator> administrator = administratorListDao
				.getAdministratorList();

		List<AdministratorListDto> administratorListDto = (List<AdministratorListDto>) (List<?>) administrator;

		return administratorListDto;
	}
}
