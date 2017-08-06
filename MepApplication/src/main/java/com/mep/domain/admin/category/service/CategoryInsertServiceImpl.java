package com.mep.domain.admin.category.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryInsertDao;
import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.log.ApplyAspect;
import com.mep.util.DateUtil;

@Service
public class CategoryInsertServiceImpl implements CategoryInsertService {

	@Autowired
	CategoryInsertDao categoryInsertDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public boolean insertCategory(CategoryDto categoryDto) throws Exception {

		categoryInsertDao.insertCategory(setDtoModelToEntityModel(categoryDto));

		return true;
	}

	private Category setDtoModelToEntityModel(CategoryDto categoryDto) {
		Category category = new Category();

		category.setCategoryName(categoryDto.getCategoryName());
		category.setCreatedDate(DateUtil.getCurrentTime());

		return category;
	}

}
