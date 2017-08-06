package com.mep.domain.admin.administrator.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.admin.administrator.dao.AdministratorDeleteDao;
import com.mep.log.ApplyAspect;

@Service
public class AdministratorDeleteServiceImpl implements
		AdministratorDeleteService {

	@Autowired
	AdministratorDeleteDao administratorDeleteDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public boolean admnistratorDelete(Integer adminId) throws Exception {
		administratorDeleteDao.admnistratorDelete(adminId);

		return true;
	}

}
