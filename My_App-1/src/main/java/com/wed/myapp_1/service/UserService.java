package com.wed.myapp_1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wed.myapp_1.common.User;
import com.wed.myapp_1.dao.UserDao;

@Service
public class UserService {

	
	@Autowired
	private UserDao userDao;
	
	public User updateUser(User user, int id) {
		return userDao.updateUser(user , id);
		
	}
	public User getUserById(int id) {
		return userDao.getUserById(id);
		
	}

}
