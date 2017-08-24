package com.mep.domain.admin.post.service;

import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Category;
import com.mep.domain.admin.post.dao.PostInitDao;
import com.mep.domain.admin.post.dto.CategoryDropdownDto;
import com.mep.log.ApplyAspect;

@Service
public class PostInitServiceImpl implements PostInitService {

	@Autowired
	private PostInitDao postInitDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public List<CategoryDropdownDto> getCategoryDropdown() throws Exception {
		List<Category> categoryDropdown = postInitDao.getCategoryDropdown();

		List<CategoryDropdownDto> categoryListDto = (List<CategoryDropdownDto>) (List<?>) categoryDropdown;

		return categoryListDto;
	}

}
