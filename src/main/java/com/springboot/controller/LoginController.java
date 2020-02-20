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
 * @create: 2020-01-15 23:35
 **/

@RestController
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestBody JSONObject jsonObject){
		Tel tel= JSON.parseObject(jsonObject.toString(),Tel.class);
		Jedis jedis=new Jedis();
		//redis(15) 存手机号密码
		jedis.select(15);
		String telenumber=tel.getTelenumber();
		String password=tel.getPassword();
		if(jedis.exists(telenumber)){
//			System.out.println("存在此帐号");
//			String password1=jedis.get(telenumber);
//			System.out.println(password1);
			if(jedis.get(telenumber).equals(password)){
				return "登录成功";
			}else {
				return "对不起，密码不正确";
			}
		}else {
			return "没有此帐号";
		}
	}


}
