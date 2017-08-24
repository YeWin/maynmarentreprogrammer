package com.mep.domain.admin.post.service;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.admin.post.dao.PostDeleteDao;
import com.mep.log.ApplyAspect;

@Service
public class PostDeleteServiceImpl implements PostDeleteService {
	
	@Autowired
	private PostDeleteDao postDeleteDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	@ApplyAspect
	public boolean postDelete(Integer postId) throws Exception {
		postDeleteDao.postDelete(postId);
		
		return true;
	}

}
