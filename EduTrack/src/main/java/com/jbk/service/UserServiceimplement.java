package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDaoInterface;
import com.jbk.entity.User;

@Service
public class UserServiceimplement implements UserServiceInterface {

	@Autowired
	UserDaoInterface userDaoInterface;
	
	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.registerUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDaoInterface.getAllUser();
	}

	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDaoInterface.getUserByUserName(username);
	}

	@Override
	public String deleteUserByUserName(String username) {
		return userDaoInterface.deleteUserByUserName(username);
	}

	@Override
	public String loginuser(User user) {
		// TODO Auto-generated method stub
		return userDaoInterface.loginuser(user);
	}

	
}
