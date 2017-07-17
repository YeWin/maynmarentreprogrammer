package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryInsertDao;
import com.mep.domain.admin.category.dto.CategoryDto;

@Service
public class CategoryInsertServiceImpl implements CategoryInsertService {
	
	@Autowired
	CategoryInsertDao categoryInsertDao;

	@Override
	public boolean insertCategory(CategoryDto categoryDto) throws Exception {

		categoryInsertDao.insertCategory(setDtoModelToEntityModel(categoryDto));
		
		return true;
	}
	
	public Category setDtoModelToEntityModel(CategoryDto categoryDto) {
		Category category = new Category();		
		
		category.setCategoryName(categoryDto.getCategoryName());
		
		return category;
	}

}
