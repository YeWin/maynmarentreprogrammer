package com.mep.domain.admin.post.service;

import javax.servlet.http.HttpServletRequest;

import com.mep.domain.admin.post.dto.PostDto;

public interface PostInsertService {

	boolean insertPost(HttpServletRequest request, PostDto postDto) throws Exception;
}
