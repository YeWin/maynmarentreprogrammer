package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryUpdateDao;
import com.mep.domain.admin.category.dto.CategoryDto;

@Service
public class CategoryUpdateServiceImpl implements CategoryUpdateService {
	
	@Autowired
	CategoryUpdateDao categoryUpdateDao;

	@Override
	public CategoryDto getCategoryById(Integer categoryId) throws Exception {

		Category category = categoryUpdateDao.getCategoryById(categoryId);
		
		return setEntityModelToDtoModel(category);
	}
	
	public CategoryDto setEntityModelToDtoModel(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		
		return categoryDto;
	}

}
