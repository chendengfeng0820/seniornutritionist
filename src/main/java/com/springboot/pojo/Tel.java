package com.springboot.pojo;

/**
 * @author: cdf
 * @create: 2020-02-13 16:51
 **/
public class Tel {

	private String telenumber;

	private String code;

	public String getTelenumber() {
		return telenumber;
	}

	public void setTelenumber(String telenumber) {
		this.telenumber = telenumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Tel{" +
				"telenumber='" + telenumber + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
