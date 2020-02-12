package com.springboot.pojo;

import java.io.Serializable;

/**
 * @author: cdf
 * @create: 2020-02-12 23:40
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
				'}';
	}
}
