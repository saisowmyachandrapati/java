package com.wed.myapp_1.dao;

import com.wed.myapp_1.common.User;

public interface UserDao {
	
	public User updateUser(User user, int id);
	public User getUserById(int id);

}
