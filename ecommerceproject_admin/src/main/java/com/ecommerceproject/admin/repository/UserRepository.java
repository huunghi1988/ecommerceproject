package com.ecommerceproject.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceproject.admin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
