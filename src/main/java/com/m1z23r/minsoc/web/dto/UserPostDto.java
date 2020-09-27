package com.m1z23r.minsoc.web.dto;

import java.util.Date;


public class UserPostDto {
	
	private String content;
	private String photo_url;

	public UserPostDto() {}
	
	public UserPostDto(Long userId, String content, String photo_url, Date creation_date) {
		super();
		this.content = content;
		this.photo_url = photo_url;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	
	
}
