package com.mep.domain.admin.post.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostInsertDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.login.dto.SessionLoginAdminDto;
import com.mep.log.ApplyAspect;
import com.mep.util.Constant;
import com.mep.util.DateUtil;

@Service
public class PostInsertServiceImpl implements PostInsertService { 
	
	@Autowired
	PostInsertDao postInsertDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public boolean insertPost(HttpServletRequest request, PostDto postDto) throws Exception {

		postInsertDao.insertPost(setDtoModelToEntityModel(request, postDto));
		
		return true;
	}
	
	private Post setDtoModelToEntityModel(HttpServletRequest request, PostDto postDto)
			throws Exception {
		Post post = new Post();		
		
		post.setAdminId(getAdminIdFromSession(request));
		post.setCategoryId(postDto.getCategoryId());
		post.setPostTitleEng(postDto.getPostTitleEng());
		post.setPostTitleMmr(postDto.getPostTitleMmr());
		post.setPostTitleImgUrl(postDto.getPostTitleImgUrl());
		post.setPostContent(postDto.getPostContent());
		post.setCreatedDate(DateUtil.getCurrentTime());
		
		return post;
	}
	
	private Integer getAdminIdFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionLoginAdminDto sessionDto = (SessionLoginAdminDto)session.getAttribute(Constant.SESSION_KEY);
		
		return sessionDto.getAdminId();
	}

}
