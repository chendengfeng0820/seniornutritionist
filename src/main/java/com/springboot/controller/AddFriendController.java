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
 * @create: 2020-01-13 23:39
 **/
@RestController
public class AddFriendController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/selectfriend")
	public String addFriend(@RequestBody JSONObject jsonObject){
		User user= JSON.parseObject(jsonObject.toString(),User.class);

		String number=String.valueOf(user.getNumber());
		Jedis jedis=new Jedis();
		jedis.select(15);
		if(jedis.exists(number)){
			User user1=userMapper.findByNumber(Integer.valueOf(number));
			return JSON.toJSONString(user1);
		}else {

			return "不存在此用户";
		}
	}
}
