package com.springboot.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: cdf
 * @create: 2020-01-12 23:40
 **/
public class User implements Serializable {

	private int number;
	private int age;
	private float height;
	private float weight;
	private int pressure;
	private float sugar;
	private float bmi;
	private String name;
    private String resume;
    private String nikename;
    private String head;
    private char sex;
    private Date birthday;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public float getSugar() {
		return sugar;
	}

	public void setSugar(float sugar) {
		this.sugar = sugar;
	}

	public float getBmi() {
		return bmi;
	}

	public void setBmi(float bmi) {
		this.bmi = bmi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", pressure=" + pressure +
                ", sugar=" + sugar +
                ", bmi=" + bmi +
                ", name='" + name + '\'' +
                ", resume='" + resume + '\'' +
                ", nikename='" + nikename + '\'' +
                ", head='" + head + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
