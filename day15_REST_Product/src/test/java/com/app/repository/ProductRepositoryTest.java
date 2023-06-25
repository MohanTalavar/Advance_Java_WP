package com.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Product;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ProductRepositoryTest {
	
	@Autowired
	private ProductDao dao;

	@Test
	void testGetAllProds() {
		
		List<Product> list = List.of( new Product("Almond", 100, 250, "increase memory power"), 
				new Product("dates", 300, 500, "tasty"),
				new Product("cashew", 50, 700,"salty")
				);
		
		List<Product> list2 = dao.saveAll(list);
		
	}

}
