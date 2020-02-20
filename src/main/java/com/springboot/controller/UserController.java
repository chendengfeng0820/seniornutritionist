package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: cdf
 * @create: 2020-01-13 00:33
 **/
@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/findAll")
	public String findAll() {
		List<User> users = userMapper.findAll();
		String Json = JSON.toJSONString(users);
		return Json;
	}

	@RequestMapping("/findByNumber")
	public String findByNumber(@RequestBody JSONObject jsonObject) {
		User user = JSON.parseObject(jsonObject.toString(), User.class);
		Integer number = user.getNumber();
		User user1 = userMapper.findByNumber(number);
		String Json = JSON.toJSONString(user1);
		return Json;
	}

	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody JSONObject jsonObject) {
		User user = JSON.parseObject(jsonObject.toString(), User.class);
		user.setName(user.getName());
		user.setAge(user.getAge());
		user.setHeight(user.getHeight());
		user.setWeight(user.getWeight());
		user.setPressure(user.getPressure());
		user.setSugar(user.getSugar());
		float BMI = user.getWeight() / (user.getHeight() * user.getHeight());
		user.setBmi(BMI);
		System.out.println(user);
		System.out.println(BMI);
		userMapper.saveUser(user);
		return "t";
	}


	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestBody JSONObject jsonObject) {
		User user = JSON.parseObject(jsonObject.toString(), User.class);
		Integer number = user.getNumber();
		userMapper.deleteUser(number);
		return "t";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@RequestBody JSONObject jsonObject) {
		User user = JSON.parseObject(jsonObject.toString(), User.class);
		Integer number=user.getNumber();
		user.setName(user.getName());
		user.setHeight(user.getHeight());
		user.setWeight(user.getWeight());
		user.setPressure(user.getPressure());
		user.setSugar(user.getSugar());
		userMapper.updateUser(user);
//		System.out.println(user);
		User user1=userMapper.findByNumber(number);
//		System.out.println(user1);
		float BMI = user1.getWeight() / (user1.getHeight() * user1.getHeight());
//		System.out.println(BMI);
		user1.setBmi(BMI);
		userMapper.updateUser(user1);
		return "t";
	}






}
