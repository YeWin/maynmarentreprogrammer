package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.domain.admin.category.dao.CategoryDeleteDao;

@Service
public class CategoryDeleteServiceImpl implements CategoryDeleteService {
	
	@Autowired
	CategoryDeleteDao categoryDeleteDao;

	@Override
	public boolean categoryDelete(Integer categoryId) throws Exception {
		categoryDeleteDao.categoryDelete(categoryId);
		
		return true;
	}

}
