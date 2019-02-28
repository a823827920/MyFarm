package com.ncuedu.entity;

import java.util.Date;

public class Order {
	private int id;
	private Date downdate;
	private Crop crop;
	private String name;
	private String tel;
	private String addr;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Date downdate, Crop crop, String name, String tel, String addr) {
		super();
		this.downdate = downdate;
		this.crop = crop;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public Order(int id, Date downdate, Crop crop, String name, String tel, String addr) {
		super();
		this.id = id;
		this.downdate = downdate;
		this.crop = crop;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDowndate() {
		return downdate;
	}
	public void setDowndate(Date downdate) {
		this.downdate = downdate;
	}
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
