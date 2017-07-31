package com.mep.domain.admin.administrator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorListDao;
import com.mep.domain.admin.administrator.dto.AdministratorListDto;

@Service
public class AdministratorListServiceImpl implements AdministratorListService {
	
	@Autowired
	private AdministratorListDao administratorListDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<AdministratorListDto> getAdministratorList() throws Exception {

		List<Administrator> administrator = administratorListDao.getAdministratorList();
		
		List<AdministratorListDto> administratorListDto = (List<AdministratorListDto>)(List<?>) administrator;
		
		return administratorListDto;
	}
}
