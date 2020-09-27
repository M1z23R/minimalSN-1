package com.m1z23r.minsoc.web.dto;

public class UserRegistrationDto {
	
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String date_of_birth;
	private String photo_url;
	private String about_me;
	private String gender;
	private String username;
	
	public UserRegistrationDto(){
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public String getAbout_me() {
		return about_me;
	}
	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserRegistrationDto(String firstName, String lastName, String email, String password, String date_of_birth,
			String photo_url, String about_me, String gender, String username) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.photo_url = photo_url;
		this.about_me = about_me;
		this.gender = gender;
		this.username = username;
	}
	
	
}
