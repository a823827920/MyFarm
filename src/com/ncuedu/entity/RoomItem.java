package com.ncuedu.entity;

import java.util.Date;

public class RoomItem {
	private int id;
	private Plant plant;
	private int field_id;
	private int user_id;
	private int flag;
	private Date date;
	private Date start;
	public RoomItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomItem(Plant plant, int field_id, int user_id, int flag, Date date, Date start) {
		super();
		this.plant = plant;
		this.field_id = field_id;
		this.user_id = user_id;
		this.flag = flag;
		this.date = date;
		this.start = start;
	}
	public RoomItem(int id, Plant plant, int field_id, int user_id, int flag, Date date, Date start) {
		super();
		this.id = id;
		this.plant = plant;
		this.field_id = field_id;
		this.user_id = user_id;
		this.flag = flag;
		this.date = date;
		this.start = start;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	
}
