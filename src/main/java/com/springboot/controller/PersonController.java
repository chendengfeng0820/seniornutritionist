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

/**
 * @author: cdf
 * @create: 2020-02-16 01:39
 **/
@RestController
public class PersonController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/shwoinformation")
	public String personal(@RequestBody JSONObject jsonObject){
		User user=JSONObject.parseObject(jsonObject.toString(),User.class);

		String number=String.valueOf(user.getNumber());
		Jedis jedis=new Jedis();
		jedis.select(13);
		if (jedis.exists(number)){
			String hgetAll=String.valueOf(jedis.hgetAll(number));
			return JSON.toJSONString(hgetAll);
		}else {
			User user1=userMapper.information(Integer.valueOf(number));
			jedis.hset(String.valueOf(user1.getNumber()),"nikename",
					String.valueOf(user1.getNikename()));
			jedis.hset(String.valueOf(user1.getNumber()),"head",
					String.valueOf(user1.getHead()));
			jedis.hset(String.valueOf(user1.getNumber()),"resume",
					String.valueOf(user1.getResume()));
			jedis.hset(String.valueOf(user1.getNumber()),"sex",
					String.valueOf(user1.getSex()));
			jedis.hset(String.valueOf(user1.getNumber()),"birthday",
					String.valueOf(user1.getBirthday()));
			String json=user1.getNikename()+user1.getNumber()+user1.getHead()+
					user1.getResume()+user1.getSex()+user1.getBirthday();
			return JSON.toJSONString(json);
		}



	}
}
