package com.ecommerceproject.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.admin.model.User;
import com.ecommerceproject.admin.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {
@Autowired
UserRepository userRepository;
@CrossOrigin
@GetMapping("/user")
public List<User> getUsers(){
	return userRepository.findAll();
}

@CrossOrigin
@GetMapping("/userDetail/{userId}")
public User getUserDetail(@PathVariable int userId){
	return userRepository.findById(userId).get();
}

@CrossOrigin
@DeleteMapping("/deleteUser/{userId}")
public void deleteUserbyId(@PathVariable int userId){
	userRepository.deleteById(userId);
	
}

@CrossOrigin
@PutMapping("/updateUser/{userId}")
public void updateUserbyId(@RequestBody User user){
	userRepository.save(user);

}
}
