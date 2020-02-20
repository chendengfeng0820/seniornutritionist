package com.springboot.service.Impl;

import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import com.springboot.service.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: cdf
 * @create: 2020-01-12 23:32
 **/
@Service
public class IUserServerImpl implements IUserServer {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	@Override
	public void deleteUser(Integer number) {
		userMapper.deleteUser(number);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public User findByNumber(Integer number) {
		return userMapper.findByNumber(number);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User information(Integer number) {
		return userMapper.information(number);
	}
}
