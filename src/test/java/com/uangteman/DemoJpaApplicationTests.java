package com.uangteman;

import java.util.ArrayList;

import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.uangteman.entity.Category;
import com.uangteman.repo.CategoryRepo;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoJpaApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoJpaApplicationTests {
	
	@Autowired TestRestTemplate testRestTemplate;
	@Autowired CategoryRepo categoryRepo;	
	@LocalServerPort int port;
	
	@Test
	public void contextLoads() {
		Category category = new Category();
        category.setName("Test Category");
        
        Category result = categoryRepo.save(category);
        Assert.assertEquals(category.getName(), result.getName());
        
        categoryRepo.delete(result);
        Assert.assertEquals(null, categoryRepo.findOne(result.getId()));
	}
		
	@Test
	public void testGetCategory() {		
		ResponseEntity<?> entity = this.testRestTemplate
				.withBasicAuth("titu@gmail.com", "202cb962ac59075b964b07152d234b70")
				.getForEntity("http://localhost:"+this.port+"/category", ArrayList.class);
		
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
}
