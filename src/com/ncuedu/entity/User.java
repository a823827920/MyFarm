package com.ncuedu.entity;

import java.math.BigDecimal;

public class User {
	private int id;
	private String password;
	private String name;
	private String sex;
	public User(int id, String password, String name, String sex, String tel, String email, BigDecimal money, int exp,
			String img, String des) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.money = money;
		this.exp = exp;
		this.img = img;
		this.des = des;
	}
	public User(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	private String tel;
	private String email;
	private BigDecimal money;
	private int exp;
	private String img;
	private String des;
	public User(String password, String name, String sex, String tel, String email, BigDecimal money, int exp,
			String img, String des) {
		super();
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.money = money;
		this.exp = exp;
		this.img = img;
		this.des = des;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String password, String name, String sex, String tel, String email, BigDecimal money, int exp) {
		super();
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.money = money;
		this.exp = exp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
