package com.mep.domain.user.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.service.ArticleDashboradService;
import com.mep.util.Constant;

@Controller
public class ArticleDashboardController {

	private static final String ARTICLE_PATH = "/user/article/content";

	private String searchValue;
	
	@Autowired
	private ArticleDashboradService dashboradService;

	@GetMapping(value = { "/searchArticle" })
	public @ResponseBody ModelAndView searchArticle(
			@RequestParam(name = "searchValue") String searchValue)
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);

		List<ArticleDashboardDto> articleDashboardList = dashboradService
				.searchArticleList(searchValue);

		mav.addObject("articleDashboardList", articleDashboardList);

		return mav;
	}

	@GetMapping(value = { "/", "/articles" })
	public @ResponseBody ModelAndView getArticles() throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);

		List<ArticleDashboardDto> articleDashboardList = dashboradService
				.getArticleDashboardList(Constant.MENU[0]);

		mav.addObject("articleDashboardList", articleDashboardList);

		return mav;
	}

	@GetMapping(value = { "/professional-programmer" })
	public @ResponseBody ModelAndView getProfessionalProgrammer()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);

		List<ArticleDashboardDto> articleDashboardList = dashboradService
				.getArticleDashboardList(Constant.MENU[1]);

		mav.addObject("articleDashboardList", articleDashboardList);

		return mav;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
