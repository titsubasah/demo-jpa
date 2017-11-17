package com.uangteman.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.dto.LoginForm;
import com.uangteman.dto.Result;
import com.uangteman.entity.User;
import com.uangteman.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public  ResponseEntity<?> register(@Valid @RequestBody User user, Errors errors) throws Exception{		
		
		Result<User> result = new Result<>();
		
		if(errors.hasErrors()) {
			errors
				.getAllErrors()
				.forEach(a -> {
					result.getMessages().add(a.getDefaultMessage());
				});
			return ResponseEntity.badRequest().body(result);
		}
				
		return ResponseEntity.ok(
				result
				.setPayload(
					userService.register(user)
					)
				);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
    public ResponseEntity<?> register(@RequestBody LoginForm form, Errors errors) throws Exception {	
		
		Result<User> result = new Result<>();
		if(errors.hasErrors()) {
			errors
				.getAllErrors()
				.forEach(error -> {
					result.getMessages().add(error.getDefaultMessage());
				});
			return ResponseEntity
					.badRequest()
					.body(result);
		}        		
		
		return ResponseEntity.ok (
				result.setPayload (userService.login (form.getUsername(), form.getPassword())));
    }
}
