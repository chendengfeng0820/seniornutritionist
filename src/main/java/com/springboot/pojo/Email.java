package com.springboot.pojo;

/**
 * @author: cdf
 * @create: 2020-01-13 20:42
 **/
public class Email {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Email{" +
				"email='" + email + '\'' +
				'}';
	}
}
