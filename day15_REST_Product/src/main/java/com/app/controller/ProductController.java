package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	public ProductController() {

		System.out.println("in ctor of: "+getClass());
	}
	
	@GetMapping
	public List<Product> getProdList(){
		
		System.out.println("in prodController getProd api");
		
		return prodService.getAllProds();
	}
	
	@PostMapping
	public Product saveProdDetails(@RequestBody Product prd)
	{
		System.out.println("in save "+prd);//not null , id : null
		return prodService.addProdDetails(prd);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
