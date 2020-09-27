package com.m1z23r.minsoc.web;


import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m1z23r.minsoc.model.Post;
import com.m1z23r.minsoc.model.User;
import com.m1z23r.minsoc.service.PostService;
import com.m1z23r.minsoc.service.UserService;
import com.m1z23r.minsoc.web.dto.UserPostDto;


@Controller
@RequestMapping("/post")
public class UserPostController {

	private PostService postService;
	private UserService userService;
	
	public UserPostController(PostService postService, UserService userService) {
		super();
		this.postService = postService;
		this.userService = userService;
	}

	@ModelAttribute("post")
    public UserPostDto userPostDto() {
        return new UserPostDto();
    }

    
	@PostMapping
	public String newUserPost(@ModelAttribute("post") UserPostDto userPostDto, Principal principal) {

		User user = userService.getUserByEmail(principal.getName());
		
		Post post = postService.save(userPostDto, user.getId());
		System.out.println(user.getId());
		return "redirect:/?success";


	}

	
}
