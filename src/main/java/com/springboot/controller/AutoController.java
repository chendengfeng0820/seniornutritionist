package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cdf
 * @create: 2020-02-14 01:08
 **/
@RestController
public class AutoController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/auto")
	public String meal(@RequestBody JSONObject jsonObject){
		User user= JSON.parseObject(jsonObject.toString(),User.class);

		Integer number=user.getNumber();
		User user1=userMapper.findByNumber(number);
		if(user1!=null) {
			Float BMI = user1.getBmi();
			Jedis jedis = new Jedis();
			jedis.select(2);
			String prognumber = jedis.get(BMI.toString());
			System.out.println("redis中BMI对应的prognumber:" + prognumber);
			jedis.select(3);
			String[] a = new String[]{"type", "proportion", "heft"};
			System.out.println(jedis.hmget(prognumber, a));
		}else {
			System.out.println("没有这个帐号");
		}
		return "t";
	}
}
