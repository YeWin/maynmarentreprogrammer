package com.mep.domain.user.article.service;

import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.user.article.dao.ArticleDashboardDao;
import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.log.ApplyAspect;

@Service
public class ArticleDashboradServiceImpl implements ArticleDashboradService {

	@Autowired
	private ArticleDashboardDao articleDashboardDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public List<ArticleDashboardDto> getArticleDashboardList(String categoryName)
			throws Exception {

		List<ArticleDashboard> dashboardList = articleDashboardDao
				.getArticleDashboardList(categoryName);

		List<ArticleDashboardDto> dashboardDtoList = (List<ArticleDashboardDto>) (List<?>) dashboardList;

		return dashboardDtoList;
	}

}
