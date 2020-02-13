package com.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.pojo.Email;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestBody;
import redis.clients.jedis.Jedis;

/**
 * @author: cdf
 * @create: 2020-02-13 16:46
 **/
public class test {

	@Test
	public void redisTest(){
		Jedis jedis=new Jedis("127.0.0.1",6379);

		System.out.println(jedis.get("18790120405"));
	}

	@Test
	public void getCheckCode() {

//		Email email = JSON.parseObject(jsonObject.toString(), Email.class);

//		String email1=email.getEmail();

		SimpleMailMessage message=new SimpleMailMessage();

		String password="123456";

		message.setSubject("您的验证码:"+password+"，验证码有效期：2分钟");
		message.setText("高级营养师");

		message.setTo("18790120405@163.com");
		message.setFrom("921132060@qq.com");
	}
}
