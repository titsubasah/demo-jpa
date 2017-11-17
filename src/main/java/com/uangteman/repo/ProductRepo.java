package com.uangteman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uangteman.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	
	@Query("select prod from Product prod where prod.category.id= :categoryId")
	public List<Product> findByCategory(@Param("categoryId") Long categoryId);
	
	@Query("select prod from Product prod where prod.name like :paramName")
	public List<Product> findByName(@Param("paramName") String paramName);
	
	@Query("select prod from Product prod")
    public List<Product> findAll();
	
	@Query("select prod from Product prod where prod.id = :id")
	public Product findOne(@Param("id") Long id);
	
	@Query("select prod from Product prod where prod.price between :min and :max")
	public List<Product> findByPriceRange(@Param("min") double min, @Param("max") double max);
	
	@Query("select count(prod) from Product prod")
	public int getTotalRecord();
}
