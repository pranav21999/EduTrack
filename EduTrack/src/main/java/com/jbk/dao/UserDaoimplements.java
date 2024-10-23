package com.jbk.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.User;
import com.jbk.exception.CustomException;

@Repository
public class UserDaoimplements implements UserDaoInterface {

	@Autowired
	SessionFactory factory;

	@Override
	public String registerUser(User user) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new CustomException("Failed to register user: " + e.getMessage());
		} finally {
			session.close();
		}
		return "Registerd User Sucessfully";
	}

	@Override
	public List<User> getAllUser() {
		Session session = null;
		List<User> list = null;
		try {
			session = factory.openSession();
			list = session.createCriteria(User.class).list();
		} catch (Exception e) {
			throw new CustomException("Failed to retrieve users: " + e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public User getUserByUserName(String username) {
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			user = session.get(User.class, username);
			if (user == null) {
				throw new CustomException("User not found with username: " + username);
			}
		} catch (Exception e) {
			throw new CustomException("An error occurred while retrieving the user: " + e.getMessage());
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public String deleteUserByUserName(String username) {
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			user = session.get(User.class, username);
			if (user == null) {
				throw new CustomException("User not found with username: " + username);
			}
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new CustomException("An error occurred while deleting the user: " + e.getMessage());
		} finally {
			session.close();
		}
		return "User Deleted Successfully";
	}

	@Override
	public String loginuser(User user) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			//get is used to fetch Entity by using primary key only
			User dbUser = session.get(User.class, user.getUsername());
			session.getTransaction().commit();

			if (dbUser != null && user.getPassword().equals(dbUser.getPassword()) ) {
				return "Login successful";
			} else {
				return "Username or password incorrect";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred during login";
		} finally {
			session.close();
		}
	}

}
