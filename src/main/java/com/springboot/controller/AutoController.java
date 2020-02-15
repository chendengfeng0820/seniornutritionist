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
import java.util.HashSet;
import java.util.Map;

/**
 * @author: cdf
 * @create: 2020-02-14 01:08
 **/
@RestController
public class AutoController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/automeal")
	public String automeal(@RequestBody JSONObject jsonObject){
		User user=JSONObject.parseObject(jsonObject.toString(),User.class);
		String number=String.valueOf(user.getNumber());

		Jedis jedis=new Jedis();
		jedis.select(12);
		String bmi=jedis.hget(number,"bmi");
		Double bmi1=Double.valueOf(bmi);
		jedis.select(11);
		String prognum=null;
		if (bmi1<18.5){
			 prognum=jedis.get(String.valueOf(18.5));
		}else if (18.5<=bmi1&&bmi1<=25){
			 prognum =jedis.get(String.valueOf(22));
		}else {
			 prognum =jedis.get(String.valueOf(25));
		}
		System.out.println(prognum);
		jedis.select(10);
		HashMap suit=new HashMap();
		if (prognum.equals("方案1")){
			suit=(HashMap) jedis.hgetAll(String.valueOf(2));
		}else if (prognum.equals("方案2")){
			suit=(HashMap) jedis.hgetAll(String.valueOf(3));
		}else if(prognum.equals("方案3")){
			suit=(HashMap) jedis.hgetAll(String.valueOf(1));
		}

		return JSON.toJSONString(suit);

	}

//	@RequestMapping("/auto")
//	public String meal(@RequestBody JSONObject jsonObject){
//		User user= JSON.parseObject(jsonObject.toString(),User.class);
//		Jedis jedis = new Jedis();
//
//		Integer number=user.getNumber();
//		String number1=jedis.get(number.toString());
//		if(number1==null) {
//			User user1 = userMapper.findByNumber(number);
//			if (user1 != null) {
//				Float BMI = user1.getBmi();
//				jedis.select(2);
//				String prognumber = jedis.get(BMI.toString());
//				System.out.println("redis中BMI对应的prognumber:" + prognumber);
//				jedis.select(3);
//				String[] a = new String[]{"type", "proportion", "heft"};
//				System.out.println(jedis.hmget(prognumber, a));
//			} else {
//				System.out.println("没有此帐号");
//			}
//		}else {
//			return number1;
//		}
//		return "t";
//	}
}
