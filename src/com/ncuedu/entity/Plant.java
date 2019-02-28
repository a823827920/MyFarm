package com.ncuedu.entity;

import java.math.BigDecimal;

public class Plant {
	private int id;
	private String name;
	private int stock;
	private BigDecimal salePrice;
	private String des;
	private BigDecimal orderPrice;
	private int cate_id;
	private String img;
	private int flag;
	public Plant(int id, String name, int stock, BigDecimal salePrice, String des, BigDecimal orderPrice, int cate_id,
			String img, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.salePrice = salePrice;
		this.des = des;
		this.orderPrice = orderPrice;
		this.cate_id = cate_id;
		this.img = img;
		this.flag = flag;
	}
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plant(String name, int stock, BigDecimal salePrice, String des, BigDecimal orderPrice, int cate_id,
			String img, int flag) {
		super();
		this.name = name;
		this.stock = stock;
		this.salePrice = salePrice;
		this.des = des;
		this.orderPrice = orderPrice;
		this.cate_id = cate_id;
		this.img = img;
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
