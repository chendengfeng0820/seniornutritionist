package com.springboot.pojo;

/**
 * @author: cdf
 * @create: 2020-02-13 16:51
 **/
public class Tel {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String telenumber;

	private String code;

	private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
				"email='" + email + '\'' +
				", telenumber='" + telenumber + '\'' +
				", code='" + code + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
