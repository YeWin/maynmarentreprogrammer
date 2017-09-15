package com.mep.domain.user.article.service;

import java.util.ArrayList;
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
import com.mep.util.StringUtil;

@Service
public class ArticleDashboradServiceImpl implements ArticleDashboradService {

	@Autowired
	private ArticleDashboardDao articleDashboardDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public List<ArticleDashboardDto> getArticleDashboardList(String categoryName)
			throws Exception {

		List<ArticleDashboard> dashboardList = articleDashboardDao
				.getArticleDashboardList(categoryName);

		return getDtoList(dashboardList);
	}

	private List<ArticleDashboardDto> getDtoList(
			List<ArticleDashboard> dashboardList) {
		List<ArticleDashboardDto> dashboardDtoList = new ArrayList<>();

		for (ArticleDashboard dashboard : dashboardList) {
			ArticleDashboardDto dto = new ArticleDashboardDto();
					
			dto.setAdminName(dashboard.getAdminName());
			dto.setCreatedDate(dashboard.getCreatedDate());
			dto.setPostId(dashboard.getPostId());
			dto.setPostTitle(dashboard.getPostTitle());
			dto.setPostTitleEng(StringUtil.replaceWhiteSpaceWithHyphen(dashboard
					.getPostTitleEng()).toLowerCase());
			dto.setPostTitleImgUrl(dashboard.getPostTitleImgUrl());

			dashboardDtoList.add(dto);
		}

		return dashboardDtoList;
	}

}
