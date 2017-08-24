package com.mep.domain.user.article.entity;

import java.io.Serializable;
import java.util.Date;

public class ArticleDashboard implements Serializable {

	private static final long serialVersionUID = 1L;

	private String postTitle;
	
	private String postTitleImgUrl;
	
	private Date createdDate;
	
	private String adminName;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostTitleImgUrl() {
		return postTitleImgUrl;
	}

	public void setPostTitleImgUrl(String postTitleImgUrl) {
		this.postTitleImgUrl = postTitleImgUrl;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
