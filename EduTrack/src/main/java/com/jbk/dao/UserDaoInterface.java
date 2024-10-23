package com.jbk.dao;

import java.util.List;

import com.jbk.entity.User;

public interface UserDaoInterface {

	public String registerUser(User user);

	public List<User> getAllUser();

	public User getUserByUserName(String username);

	public String deleteUserByUserName(String username);

	public String loginuser(User user);

	
	
}
