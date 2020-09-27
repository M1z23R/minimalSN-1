package com.m1z23r.minsoc.service;

import java.util.List;


import com.m1z23r.minsoc.model.Post;
import com.m1z23r.minsoc.web.dto.UserPostDto;

public interface PostService {
	Post save(UserPostDto userPostDto, long user_id);
	List<Post> getUserPosts(long id);
	List<Post> getAllPosts();
	void Post(Post post);
	Post getPostById(long id);
	void deletePostById(long id);
	
}
