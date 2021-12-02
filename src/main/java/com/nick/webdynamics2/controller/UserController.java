package com.nick.webdynamics2.controller;

import com.nick.webdynamics2.model.User;
import com.nick.webdynamics2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/get_user")
	public Iterable<User> getTestUser(){
		
		return userRepo.findAll();
	}
	
	@PostMapping("/add_user")
	public void addUser(@RequestBody User user){
		userRepo.save(user);
	}
	

}
