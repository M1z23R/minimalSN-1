package com.m1z23r.minsoc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.m1z23r.minsoc.model.Post;
import com.m1z23r.minsoc.repository.PostRepository;
import com.m1z23r.minsoc.web.dto.UserPostDto;

@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepository;
	//private UserService userService;
	
	@Override
	public Post getPostById(long id) {
		Optional<Post> optional = postRepository.findById(id);
		Post post = null;
		if (optional.isPresent()) {
			post = optional.get();
		} else {
			throw new RuntimeException("post not found for id: " + id);
		}
		return post;
	}


	@Override
	public void deletePostById(long id) {
		// TODO Auto-generated method stub
		this.postRepository.deleteById(id);
	}
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	
	@Override
	public Post save(UserPostDto userPostDto, long user_id) {
		Post post = new Post(user_id, userPostDto.getContent(),userPostDto.getPhoto_url(), new Date());
		return postRepository.save(post);
	}
	
	@Override
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}

	@Override
	public void Post(Post post) {
		return;
	}


	@Override
	public List<Post> getUserPosts(long id) {
		Post post = new Post();                         
		post.setUserId(id);                          
		Example<Post> example = Example.of(post); 
		return postRepository.findAll(example);
	}

	

}
