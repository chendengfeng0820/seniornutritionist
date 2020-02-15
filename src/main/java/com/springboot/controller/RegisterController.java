package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.pojo.Tel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.springboot.password.ess.generateInviteCode;

/**
 * @author: cdf
 * @create: 2020-02-16 00:29
 **/
@RestController
public class RegisterController {

	@RequestMapping("/register")
	public String register(@RequestBody JSONObject jsonObject){
		Tel tel= JSON.parseObject(jsonObject.toString(),Tel.class);
		String telenumber=tel.getTelenumber();
		String password=tel.getPassword();
		String code=tel.getCode();
		Jedis jedis=new Jedis();
		jedis.select(14);
		if(jedis.get(telenumber).equals(code)){
			jedis.select(15);
			jedis.set(telenumber,password);
			return "注册成功，返回登录页面";
		}else {
			return "验证码不正确";
		}
	}

	@RequestMapping("/code")
	public String password(@RequestBody JSONObject jsonObject) {
		Tel tel= JSON.parseObject(jsonObject.toString(),Tel.class);
		String eamil=tel.getEmail();
		long start = System.currentTimeMillis();
		Set set = new HashSet();
		for (int i = 0; i < 1000000; i++) {
			set.add(generateInviteCode(6));
		}
		Iterator iterator = set.iterator();
		String passowrd=(String) iterator.next();
		System.out.println(passowrd);
		Jedis jedis=new Jedis();
		jedis.select(14);
		jedis.set(eamil,passowrd);
		jedis.expire(eamil,120);
		return JSON.toJSONString(passowrd);
	}

}
