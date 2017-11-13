package com.mep.domain.user.archive.entity;

import java.io.Serializable;

public class ArchiveList implements Serializable {

	private static final long serialVersionUID = 1L;

	private String year;
	
	private String month;
	
	private String postTitle;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
}
