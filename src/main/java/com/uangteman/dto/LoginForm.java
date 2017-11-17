package com.uangteman.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	
	@NotBlank(message="email can't empty!")
	@Email(message="Invalid email format")
	private String username;
	@NotBlank(message="password can't empty!")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public LoginForm setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public LoginForm setPassword(String password) {
		this.password = password;
		return this;
	}
	
	

}
