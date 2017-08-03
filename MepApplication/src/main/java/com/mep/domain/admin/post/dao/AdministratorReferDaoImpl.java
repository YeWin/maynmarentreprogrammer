package com.mep.domain.admin.post.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Administrator;
import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorReferDaoImpl implements AdministratorReferDao {
	
	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public Administrator getAdminIdByEmail(String admin_email) {
		return administratorMapper.selectByEmail(admin_email);
	}

}
