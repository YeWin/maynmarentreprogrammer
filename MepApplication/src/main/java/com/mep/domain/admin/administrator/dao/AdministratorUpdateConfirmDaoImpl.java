package com.mep.domain.admin.administrator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Administrator;
import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorUpdateConfirmDaoImpl implements
		AdministratorUpdateConfirmDao {

	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public int updateAdministrator(Administrator administrator) {
		return administratorMapper.updateByPrimaryKeySelective(administrator);
	}

}
