package com.mep.domain.admin.post.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostUpdateDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.log.ApplyAspect;

@Service
public class PostUpdateServiceImpl implements PostUpdateService {

	@Autowired
	PostUpdateDao postUpdateDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public PostDto getPostById(Integer postId) throws Exception {

		Post post = postUpdateDao.getPostById(postId);

		return setEntityModelToDtoModel(post);
	}

	private PostDto setEntityModelToDtoModel(Post post) {
		PostDto postDto = new PostDto();

		postDto.setPostId(post.getAdminId());
		postDto.setCategoryId(post.getCategoryId());
		postDto.setPostTitleEng(post.getPostTitleEng());
		postDto.setPostTitleMmr(post.getPostTitleMmr());
		postDto.setPostContent(post.getPostTitleImgUrl());

		return postDto;
	}

}
