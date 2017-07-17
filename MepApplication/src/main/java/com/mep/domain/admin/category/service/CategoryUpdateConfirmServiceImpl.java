package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryUpdateConfirmDao;
import com.mep.domain.admin.category.dto.CategoryDto;

@Service
public class CategoryUpdateConfirmServiceImpl implements CategoryUpdateConfirmService {
	
	@Autowired
	CategoryUpdateConfirmDao categoryUpdateConfirmDao;

	@Override
	public boolean updateCategory(CategoryDto categoryDto) {

		categoryUpdateConfirmDao.updateCategory(setDtoModelToEntityModel(categoryDto));
		
		return true;
	}
	
	public Category setDtoModelToEntityModel(CategoryDto categoryDto) {
		Category category = new Category();
		
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryName(categoryDto.getCategoryName());
		
		return category;
	}

}
