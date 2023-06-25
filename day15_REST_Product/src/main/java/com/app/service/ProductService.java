package com.app.service;

import java.util.List;

import com.app.entities.Product;

public interface ProductService {
	
	List<Product> getAllProds();

	Product addProdDetails(Product prd);

}
