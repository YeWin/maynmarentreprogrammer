package com.mep.domain.admin.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.domain.admin.post.dao.PostDeleteDao;

@Service
public class PostDeleteServiceImpl implements PostDeleteService {
	
	@Autowired
	PostDeleteDao postDeleteDao;

	@Override
	public boolean postDelete(Integer postId) throws Exception {
		postDeleteDao.postDelete(postId);
		
		return true;
	}

}
