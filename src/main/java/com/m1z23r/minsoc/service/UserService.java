package com.m1z23r.minsoc.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.m1z23r.minsoc.model.User;
import com.m1z23r.minsoc.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	User getUserByEmail(String email);
	List<User> getAllUsers();
	void User(User user);
	User getUserById(long id);
	void deleteUserById(long id);
}
