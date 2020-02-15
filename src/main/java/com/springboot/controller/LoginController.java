package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.springboot.pojo.Tel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author: cdf
 * @create: 2020-02-15 23:35
 **/

@RestController
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestBody JSONObject jsonObject){
		Tel tel= JSON.parseObject(jsonObject.toString(),Tel.class);
		Jedis jedis=new Jedis();
		String telenumber=tel.getTelenumber();
		String password=tel.getPassword();
		jedis.get(telenumber)
		return "t";
	}


}
