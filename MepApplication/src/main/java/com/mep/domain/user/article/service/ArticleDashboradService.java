package com.mep.domain.user.article.service;

import java.util.List;

import com.mep.domain.user.article.dto.ArticleDashboardDto;

public interface ArticleDashboradService {

	List<ArticleDashboardDto> getArticleDashboardList(String categoryName)
			throws Exception;
	
	List<ArticleDashboardDto> searchArticleList(String searchValue)
			throws Exception;
}
