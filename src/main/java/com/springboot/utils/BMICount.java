package com.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: cdf
 * @create: 2020-02-13 00:50
 **/
public class BMICount {

	@Autowired
	private UserMapper userMapper;

	public void returnMBI(){

		List<User> userList=userMapper.findAll();



	}
}
