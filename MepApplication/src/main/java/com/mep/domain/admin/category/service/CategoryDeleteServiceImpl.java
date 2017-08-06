package com.mep.domain.admin.category.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.admin.category.dao.CategoryDeleteDao;
import com.mep.log.ApplyAspect;

@Service
public class CategoryDeleteServiceImpl implements CategoryDeleteService {

	@Autowired
	CategoryDeleteDao categoryDeleteDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public boolean categoryDelete(Integer categoryId) throws Exception {
		categoryDeleteDao.categoryDelete(categoryId);

		return true;
	}

}
