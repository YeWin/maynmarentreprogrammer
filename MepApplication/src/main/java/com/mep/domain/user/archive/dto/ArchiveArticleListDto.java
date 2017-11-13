package com.mep.domain.user.archive.dto;

import java.io.Serializable;

public class ArchiveArticleListDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String postTitle;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
}
