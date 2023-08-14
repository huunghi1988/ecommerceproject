package com.ecommerceproject.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceproject.admin.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	
}

