package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.User;
import com.jbk.service.UserServiceInterface;

@RestController
public class UserController {
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@PostMapping("user/register-user")
	public String registerUser(@RequestBody User user)
	{
		return userServiceInterface.registerUser(user);
	}
	
	@GetMapping("user/get-all-user")
	public List<User> getAllUser()
	{
	return userServiceInterface.getAllUser();
	}
	
	@GetMapping("user/get-user-by-username/{username}")
	public User getUserByUserName(@PathVariable String username)
	
	{
		return userServiceInterface.getUserByUserName(username);
	}
	
	@DeleteMapping("user/delete-user-by-username/{username}")
	public String deleteUserByUserName(@PathVariable String username)
	{
		return userServiceInterface.deleteUserByUserName(username);
	}
	
	@PostMapping("user/login-user")
	public String loginuser(@RequestBody User user)
	{
		return userServiceInterface.loginuser(user);
	}
	
}
