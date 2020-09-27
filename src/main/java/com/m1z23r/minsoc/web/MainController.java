package com.m1z23r.minsoc.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.m1z23r.minsoc.model.Post;
import com.m1z23r.minsoc.model.User;
import com.m1z23r.minsoc.repository.UserRepository;
import com.m1z23r.minsoc.service.PostService;
import com.m1z23r.minsoc.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home(Model model) {
		List<Post> posts = postService.getAllPosts();
		for (Post post : posts) {
			post.setUserName(userService.getUserById(post.getUserId()).getFirst_name() + " " + userService.getUserById(post.getUserId()).getLast_Name());
		}
		model.addAttribute("listAllPosts", posts);
		return "index";
	}


	
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "users";
	}
	
	
	@GetMapping("/users/{id}")
	public String users(@PathVariable ( value = "id") long id, Model model) {
		List<Post> posts = postService.getUserPosts(id);
		for (Post post : posts) {
			post.setUserName(userService.getUserById(post.getUserId()).getFirst_name() + " " + userService.getUserById(post.getUserId()).getLast_Name());
		}
		User user = userService.getUserById(id);
		model.addAttribute("listUserPosts", posts);
		model.addAttribute("user", user);
		return "user";
	}
	
	
}