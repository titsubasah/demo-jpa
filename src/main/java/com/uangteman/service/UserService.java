package com.uangteman.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uangteman.entity.User;
import com.uangteman.repo.UserRepo;

@Service("userService")
@Transactional
public class UserService implements UserDetailsService{
	
	@Autowired private UserRepo repo;
	
	public User register(User user) throws Exception{
		if(repo.findByEmail(user.getUsername())!=null) {
			
			throw new Exception("Email already registered");
		}
		
		return repo.save(user);
	}
	
	public User login(String email, String password) throws Exception {
        User user = repo.login(email, password);        
        if(user != null) {
            return user;
        }else {
            throw new Exception("Login failed");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("No Username found");
        }else {
            List<String> userRoles = new ArrayList<>();
            userRoles.add("admin");
            return new User(user, userRoles);
        }
    }
}
