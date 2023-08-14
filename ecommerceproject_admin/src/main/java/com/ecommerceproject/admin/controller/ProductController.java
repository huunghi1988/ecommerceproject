package com.ecommerceproject.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.admin.model.Product;
import com.ecommerceproject.admin.repository.ProductRepository;

@RestController
public class ProductController {
@Autowired
ProductRepository productRepository;

@GetMapping("/product")
public List<Product> getProduct(){
	return productRepository.findAll();
}

}
