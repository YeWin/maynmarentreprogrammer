package com.mep.domain.admin.post.dao;

import java.util.List;

import com.mep.database.entity.Post;

public interface PostListDao {

	public List<Post> getPostList(Post post);
}
