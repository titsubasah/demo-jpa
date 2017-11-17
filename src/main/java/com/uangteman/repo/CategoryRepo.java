package com.uangteman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uangteman.entity.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	
	@Query("select cat from Category cat where cat.name like :paramName")
	public List<Category> findByName(@Param("paramName") String paramName);
	
	@Query("select cat from Category cat")
    public List<Category> findAll();
	
	@Query("select cat from Category cat where cat.id = :id")
	public Category findOne(@Param("id") Long id);
}
