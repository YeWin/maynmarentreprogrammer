package com.mep.domain.admin.category.service;

import com.mep.domain.admin.category.dto.CategoryDto;

public interface CategoryInsertService {

	boolean insertCategory(CategoryDto categoryDto) throws Exception;
}
