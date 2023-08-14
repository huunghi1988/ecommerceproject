package com.ecommerceproject.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.admin.model.Category;
import com.ecommerceproject.admin.repository.CategoryRepository;

@RestController
public class CategoryController {
@Autowired
CategoryRepository categoryRepository;

@GetMapping("/category")
public List<Category> getCategorys(){
	return categoryRepository.findAll();
}

}
