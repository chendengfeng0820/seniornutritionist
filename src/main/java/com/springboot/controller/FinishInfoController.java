package com.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author: cdf
 * @create: 2020-02-16 03:07
 **/
@RestController
public class FinishInfoController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/finishinfo")
	public String finisninfo(@RequestBody JSONObject jsonObject){
		User user=JSONObject.parseObject(jsonObject.toString(),User.class);
		Integer number=user.getNumber();
		String name=user.getName();
		Integer age=user.getAge();
		float height=user.getHeight();
		float weight=user.getWeight();
		Integer pressure=user.getPressure();
		float sugar=user.getSugar();
		float bmi  =  (float)(Math.round((weight/(height*height))*100))/100;
		user.setBmi(bmi);
		Jedis jedis=new Jedis();
		jedis.select(12);
		jedis.hset(String.valueOf(number),"name",name);
		jedis.hset(String.valueOf(number),"age",String.valueOf(age));
		jedis.hset(String.valueOf(number),"height",String.valueOf(height));
		jedis.hset(String.valueOf(number),"weight",String.valueOf(weight));
		jedis.hset(String.valueOf(number),"pressure",String.valueOf(pressure));
		jedis.hset(String.valueOf(number),"sugar",String.valueOf(sugar));
		jedis.hset(String.valueOf(number),"bmi",String.valueOf(bmi));

		userMapper.saveUser(user);
		return "t";

	}
}
