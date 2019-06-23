package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.po.User;

@Service("userService")
public class UserServiceImp implements UserService {
	
	@Autowired UserDao userDao;
	
	@Override
	public User userCheck(User user) {
		return userDao.userCheck(user);
	}

}
