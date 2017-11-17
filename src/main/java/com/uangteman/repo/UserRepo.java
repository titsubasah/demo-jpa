package com.uangteman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uangteman.entity.User;

public interface UserRepo extends CrudRepository<User, Long>{
		
	@Query("select u from User u where u.username= :username and u.password= :password")
    public User login(@Param("username") String username, @Param("password") String password);
    
    @Query("select u from User u where u.fullname like :fullname")
    public List<User> findByName(@Param("fullname") String fullname);    
    
    @Query("select u from User u where u.username = :username")
    public User findByEmail(@Param("username") String username);
 }
