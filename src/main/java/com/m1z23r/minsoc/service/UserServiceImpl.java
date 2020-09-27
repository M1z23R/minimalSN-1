package com.m1z23r.minsoc.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.m1z23r.minsoc.model.Role;
import com.m1z23r.minsoc.model.User;
import com.m1z23r.minsoc.repository.UserRepository;
import com.m1z23r.minsoc.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	
	
	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" User not found for id: " + id);
		}
		return user;
	}
	
	@Override
	public void deleteUserById(long id) {
		this.userRepository.deleteById(id);
	}

	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getUsername(), registrationDto.getEmail(),
				registrationDto.getFirstName(),registrationDto.getLastName(), registrationDto.getDate_of_birth(),
				passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getPhoto_url(),registrationDto.getAbout_me(),
				registrationDto.getGender(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByemail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<com.m1z23r.minsoc.model.User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void User(com.m1z23r.minsoc.model.User user) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" User not found for email: " + email);
		}
		return user;
	}
	
	
}
