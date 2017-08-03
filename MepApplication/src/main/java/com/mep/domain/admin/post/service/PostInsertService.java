package com.mep.domain.admin.post.service;

import com.mep.domain.admin.post.dto.PostDto;

public interface PostInsertService {

	boolean insertPost(PostDto postDto) throws Exception;
}
