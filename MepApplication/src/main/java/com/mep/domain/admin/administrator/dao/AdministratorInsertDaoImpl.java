package com.mep.domain.admin.administrator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Administrator;
import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorInsertDaoImpl implements AdministratorInsertDao {
	
	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public int insertAdministrator(Administrator administrator) {
		return administratorMapper.insertSelective(administrator);
	}

}
