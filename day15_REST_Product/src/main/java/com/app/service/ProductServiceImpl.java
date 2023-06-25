package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Product;
import com.app.repository.ProductDao;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> getAllProds() {
		
		System.out.println("in service impl getallprod api");
		
		return dao.findAll();
	}

	@Override
	public Product addProdDetails(Product prd) {
		
		System.out.println("in serviceimpl ");
		return dao.save(prd);
	}

}
