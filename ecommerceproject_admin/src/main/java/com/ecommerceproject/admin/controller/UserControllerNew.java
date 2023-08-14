package com.ecommerceproject.admin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.admin.dto.UserDTO;

@RestController

public class UserControllerNew {

public UserDTO getUser() {
UserDTO user =new UserDTO();
user.setEmail("testemail");
return user;
}
}
