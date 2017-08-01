package com.mep.domain.admin.category.service;

import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryListDao;
import com.mep.domain.admin.category.dto.CategoryListDto;

@Service
public class CategoryListServiceImpl implements CategoryListService {

	@Autowired
	private CategoryListDao categoryListDao;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	public List<CategoryListDto> getCategoryList() throws Exception {

		List<Category> category = categoryListDao.getCategoryList();

		List<CategoryListDto> categoryListDto = (List<CategoryListDto>) (List<?>) category;

		return categoryListDto;
	}

}
