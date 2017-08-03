package com.mep.domain.admin.post.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Administrator;
import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.AdministratorReferDao;
import com.mep.domain.admin.post.dao.PostInsertDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.DateUtil;

@Service
public class PostInsertServiceImpl implements PostInsertService { 
	
	@Autowired
	PostInsertDao postInsertDao;
	
	@Autowired
	AdministratorReferDao administratorReferDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	public boolean insertPost(PostDto postDto) throws Exception {

		postInsertDao.insertPost(setDtoModelToEntityModel(postDto));
		
		return true;
	}
	
	private Post setDtoModelToEntityModel(PostDto postDto)
			throws Exception {
		Post post = new Post();
		
		post.setAdminId(getAdminIdByEmail("yewin@programmer.com"));
		post.setCategoryId(postDto.getCategoryId());
		post.setPostTitleEng(postDto.getPostTitleEng());
		post.setPostTitleMmr(postDto.getPostTitleMmr());
		post.setPostTitleImgUrl(postDto.getPostTitleImgUrl());
		post.setPostContent(postDto.getPostContent());
		post.setCreatedDate(DateUtil.getCurrentTime());
		
		return post;
	}
	
	private Integer getAdminIdByEmail(String email) {
		
		Administrator admin = administratorReferDao.getAdminIdByEmail(email);
		
		return admin.getAdminId();
	}

}
