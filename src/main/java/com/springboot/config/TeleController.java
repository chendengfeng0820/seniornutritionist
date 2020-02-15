//package com.springboot.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.springboot.pojo.Email;
//import com.springboot.pojo.User;
//import com.springboot.service.MailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Random;
//import java.util.Set;
//
//import static com.springboot.password.ess.generateInviteCode;
//
///**
// * @author: cdf
// * @create: 2020-02-13 20:20
// **/
//@RestController
//public class TeleController {
//
//	@Autowired
//	private JavaMailSenderImpl mailSender;
//
//	@RequestMapping("/password")
//	public String password() {
//		long start = System.currentTimeMillis();
//		Set set = new HashSet();
//		for (int i = 0; i < 1000000; i++) {
//			set.add(generateInviteCode(6));
//		}
//		//生成邀请码的个数
//		Iterator iterator = set.iterator();
////		for (int i = 0; i < 1; i++) {
////			System.out.println(iterator.next());
////		}
//        String passowrd=(String) iterator.next();
//        System.out.println(passowrd);
//        return JSON.toJSONString(passowrd);
//	}
//
//
//
//	@RequestMapping("/code")
//	public String getCheckCode1(@RequestBody JSONObject jsonObject) {
//
//		Email email = JSON.parseObject(jsonObject.toString(), Email.class);
//
//		String email1=email.getEmail();
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		String password = password();
//
//		message.setText("您的验证码:" + password + "，验证码有效期：2分钟");
//		message.setSubject("高级营养师");
//
//		message.setTo(email1);
//		message.setFrom("921132060@qq.com");
//
//		mailSender.send(message);
//
//		return "t";
//	}
//}
